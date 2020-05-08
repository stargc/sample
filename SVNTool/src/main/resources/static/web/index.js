$(document).ready(function(){
	if(window.sessionStorage.getItem('accountInfo')){
		$(".log-page").hide()
		$("#mainContainer").show();
    }
  let vm = new Vue ({
	el: "#logMain",
    data() {
      return {
		logParams: {
          userInput:"",
		  passwordInput: "",
		},
		rules: {
		  userInput: [{ required: true, message: "请输入用户名", trigger: "blur" }],
		  passwordInput: [{ required: true, message: "请输入密码", trigger: "blur" }],
		},
		loading: false
      };
    },
    methods: {
		log(formName) {
		this.$refs[formName].validate((valid) => {
          if (valid) {
          vm.loading = true
		  let pwd = hex_md5(vm.logParams.passwordInput);
		  let name = vm.logParams.userInput
		  $.ajax({
            type : "POST",
            dataType: "JSON",
			url : 'http://localhost:22006/svn/api/user/_login',
			data: {userName:name,password:pwd},
            success : function(result) {
				vm.loading = false
			    if(result.status != 0){
				  vm.$message({message: result.error,type: 'error'});
				  return false 
			    }
			    var token = result.data || ""
				window.sessionStorage.setItem("accountInfo", JSON.stringify({"token":token,"name":name}));
			    vm.$message({message: '登录成功！',type: 'success'})	
				vm_1.userName = name
			    $(".log-page").hide()
			    $("#mainContainer").show();
            },
            error : function(e){
				vm.loading = false
				vm.$message({message: '登录失败！',type: 'error'});
                console.log(e);
				return false
            }
          });
          } else {
            return false;
          }
        });
		}
    }
  });
  let vm_1 = new Vue ({
	el: "#test",
    data() {
      return {
		activeIndex: "4",
        activeName: 'first',
		userName: window.sessionStorage.getItem('accountInfo') == null ? "" : JSON.parse(window.sessionStorage.getItem('accountInfo')).name,
		productOptions: [],
		productValue: [],
		userOptions: [],
		selectedUser: [],
		timeValue: "",
		exportCode: "",
		exportName: "",
		realNameInput: "",
		tableData: [],
		currentPage: 1,
		pageSize: 5,
		totalSize: 0,
		tableKey: 0,
		selectLoading: false,
		actionLoading: false,
		
		addDialogVisible: false,
		editDialogVisible: false,
		productTable: {
			tableKey: 0,
			tableData: [{name:"",repositoryUrl:"",description:""}],
			addFormData: {name:"",description:"",repositoryUrl:""}, 
			updateFormData: {id:"",name:"",description:"",repositoryUrl:""},
			currentPage: 1,
			totalSize: 0
		}
		
      };
    },
    methods: {
	  handleSelect(key, keyPath) {
		  this.activeIndex=key;
	      vm_1.productValue = key == 1 ? [] : ""
		  vm_1.selectedUser= key == 1 ? [] : ""
		  vm_1.timeValue = ""
		  vm_1.exportCode = ""
		  vm_1.exportName = ""
		  vm_1.realNameInput = ""
	  },
	  exportProduct() {
		var data = {
			"productIds": this.productValue.join(","),
			"svnUserids": this.selectedUser.join(","),
			"overdueDate": this.timeValue,
			"projectCode": this.exportCode,
			"projectName": this.exportName
        }
		this.actionLoading = true
          $.ajax({
            type : "POST",
            contentType: "application/json;charset=UTF-8",
            url : "http://localhost:22006/svn/api/delivery/add",
			data: JSON.stringify(data),
			headers: {token: JSON.parse(window.sessionStorage.getItem('accountInfo')).token || ""},
            success : function(result) {
			  vm_1.actionLoading = false
			   if(result.status != 0) {
				   vm_1.$message({message: result.error,type: 'error'});
				   return
				}			  
			  //vm_1.$message({message: '出库成功！',type: 'success'});
		    var userNames = result.svnUser || ""
			var svnPath = result.repositoryUrl || ""
			var time = result.overdueDate || ""
			vm_1.$notify({
				title: '出库成功',
				dangerouslyUseHTMLString: true,
				message: `<div style="word-break:break-all"><p>您好：</p><span>申请的产品已出库，访问信息如下：</br><div style="display:inline-block;width: 4px;height: 4px;margin-bottom:2px;border: 1px solid black;border-radius: 8px;background-color: black;opacity: 0.5;"></div> SVN用户名：${userNames}</br><div style="display:inline-block;width: 4px;height: 4px;margin-bottom:2px;border: 1px solid black;border-radius: 8px;background-color: black;opacity: 0.5;"></div> 初始密码：ehl1234 </br><div style="display:inline-block;width: 4px;height: 4px;margin-bottom:2px;border: 1px solid black;border-radius: 8px;background-color: black;opacity: 0.5;"></div>  SVN路径：${svnPath}</br><p style="font-weight:bold;color:#FFFF00"><i class="el-icon-warning-outline"></i> 温馨提示：</p>安装文件有效期至${time}，请尽快完成下载！</span></div>`,
				type: 'success',
				duration: 0,
				offset: 52
				});	
            },
            error : function(e){
		      vm_1.actionLoading = false
	          vm_1.$message({message: '出库失败！',type: 'error'});
            }
          });		
	  },
	  bindName() {
		this.actionLoading = true 
		var data = { "id":this.selectedUser,
					 "realName":this.realNameInput
				}
          $.ajax({
            type : "POST",
            contentType: "application/json;charset=UTF-8",
            url : "http://localhost:22006/svn/api/svnuser/updateUser",
			data: JSON.stringify(data),
			headers: {token: JSON.parse(window.sessionStorage.getItem('accountInfo')).token || ""},
            success : function(result) {
			   vm_1.actionLoading = false
			   if(result.status != 0) {
				   vm_1.$message({message: result.error,type: 'error'});
				   return
				}			   
                vm_1.$message({message: '绑定成功！',type: 'success'});
            },
            error : function(e){
				vm_1.actionLoading = false
                vm_1.$message({message: '绑定失败！',type: 'error'});
                console.log(e);
            }
          });		      
		  
	  },
	  search() {
		var data = {
			"userId":vm_1.selectedUser,
			"productId":vm_1.productValue,
			"projectCode":vm_1.exportCode,
			"index":vm_1.currentPage-1,
			"num":vm_1.pageSize
			}  
		vm_1.actionLoading = true
		vm_1.tableData.length = 0
          $.ajax({
            type : "POST",
            contentType: "application/json;charset=UTF-8",
            url : "http://localhost:22006/svn/api/delivery/_search",
			data: JSON.stringify(data),
			headers: {token: JSON.parse(window.sessionStorage.getItem('accountInfo')).token || ""},
            success : function(result) {
			   vm_1.actionLoading = false
			   if(result.status != 0) {
				   vm_1.$message({message: result.error,type: 'error'});
				   return
				}
			   var data = result.data
			   vm_1.totalSize = data.count
			   for(var item of data.views){
				   item.access = item.access == 'r' ? "只读" : item.access == 'w' ? "读写" : "无权限"
				   item.status = item.status == '0' ? "已出库" : "已关闭"
				   vm_1.tableData.push(item)
			   }  
			   vm_1.tableKey++ 
            },
            error : function(e){
				vm_1.actionLoading = false
                vm_1.$message({message: '查询失败！',type: 'error'});
                console.log(e);
            }
          });		  
		  
		  
	  },
	  addProduct() {this.productTable.addFormData = {name:"",description:"",repositoryUrl:""};this.addDialogVisible=true},
	  doAddProduct() {
          var data = this.productTable.addFormData
		  this.actionLoading = true
		  $.ajax({
            type : "POST",
            contentType: "application/json;charset=UTF-8",
            url : "http://localhost:22006/svn/api/product/add",
			data: JSON.stringify(data),
			headers: {token: JSON.parse(window.sessionStorage.getItem('accountInfo')).token || ""},
            success : function(result) {
			   vm_1.actionLoading = false
			   vm_1.addDialogVisible = false
			   if(result.status != 0) {
				   vm_1.$message({message: result.error,type: 'error'});
				   return
				}				
                vm_1.$message({message: '添加成功！',type: 'success'});
				vm_1.handleTableLoad();
            },
            error : function(e){
				vm_1.actionLoading = false
                vm_1.$message({message: '添加失败！',type: 'error'});
                console.log(e);
            }
          });			  
		  
	  },
	  getProduct() {this.productOptions.length = 0;
   	      this.selectLoading = true
          $.ajax({
            type : "GET",
            dataType: "JSON",
            url : "http://localhost:22006/svn/api/product/_searchAll",
			headers: {token: JSON.parse(window.sessionStorage.getItem('accountInfo')).token || ""},
            success : function(result) {
				vm_1.selectLoading = false
			   if(result.status != 0) {return}
			   for(var item of result.data){
                 vm_1.productOptions.push({
				  value: item.id,
				  label: item.name
				 })
			   }
            },
            error : function(e){
				vm_1.selectLoading = false
                console.log(e);
            }
          });
		},
	  getUsers() {this.userOptions.length = 0;
	      this.selectLoading = true
          $.ajax({
            type : "GET",
            dataType: "JSON",
            url : "http://localhost:22006/svn/api/svnuser/_searchAll",
			headers: {token: JSON.parse(window.sessionStorage.getItem('accountInfo')).token || ""},
            success : function(result) {
			   vm_1.selectLoading = false
			   if(result.status != 0) {return}
			   for(var item of result.data){
                 vm_1.userOptions.push({
				  value: item.id,
				  label: item.userName + " (" + item.realName + ")"
				 })
			   }
            },
            error : function(e){
				vm_1.selectLoading = false
                console.log(e);
				                 vm_1.userOptions.push({
				  value:"01",
				  label: "yonghu1"
				 })
				 				                 vm_1.userOptions.push({
				  value:"02",
				  label: "yonghu2"
				 })
            }
          });	    	  
	  },
      handleCurrentChange(val) {
		  this.currentPage = val;
		  this.search();
      },
	  handleProductCurrentChange(val){
		  this.productTable.currentPage = val
	  },
	  handleEdit(index, row){
		 for(let key in this.productTable.updateFormData){
			this.productTable.updateFormData[key] = row[key] || "" 
		 }		 
		 this.editDialogVisible = true
	  },
	  doUpdateProduct() {
          var data = this.productTable.updateFormData
		  this.actionLoading = true
		  $.ajax({
            type : "PUT",
            contentType: "application/json;charset=UTF-8",
            url : "http://localhost:22006/svn/api/product/updateUser",
			data: JSON.stringify(data),
			headers: {token: JSON.parse(window.sessionStorage.getItem('accountInfo')).token || "","X-HTTP-Method-Override": "PUT" },
            success : function(result) {
			   vm_1.actionLoading = false
			   vm_1.editDialogVisible = false
			   if(result.status != 0) {
				   vm_1.$message({message: result.error,type: 'error'});
				   return
				}				
                vm_1.$message({message: '修改成功！',type: 'success'});
				vm_1.handleTableLoad();
            },
            error : function(e){
				vm_1.actionLoading = false
                vm_1.$message({message: '修改失败！',type: 'error'});
                console.log(e);
            }
          });			   
	  },
	  
	  handleDelete(index, row){
		  this.actionLoading = true
		  $.ajax({
            type : "DELETE",
            contentType: "application/json;charset=UTF-8",
            url : `http://localhost:22006/svn/api/product/${row.id}`,
			headers: {token: JSON.parse(window.sessionStorage.getItem('accountInfo')).token || ""},
            success : function(result) {
			   vm_1.actionLoading = false
			   if(result.status != 0) {
				   vm_1.$message({message: result.error,type: 'error'});
				   return
				}				
                vm_1.$message({message: '删除成功！',type: 'success'});
				vm_1.handleTableLoad();
            },
            error : function(e){
				vm_1.actionLoading = false
                vm_1.$message({message: '删除失败！',type: 'error'});
                console.log(e);
            }
          });			  
		  
	  },
	  handleTableLoad() {
          this.actionLoading = true
		  $.ajax({
            type : "GET",
            dataType: "JSON",
            url : "http://localhost:22006/svn/api/product/_searchAll",
			headers: {token: JSON.parse(window.sessionStorage.getItem('accountInfo')).token || ""},
            success : function(result) {
			   vm_1.actionLoading = false
			   if(result.status != 0) {return}
			   vm_1.productTable.tableData = result.data
			   vm_1.productTable.totalSize = result.data.length
			   
            },
            error : function(e){
			    vm_1.actionLoading = false
                console.log(e);
            }
          });	
	  },
	  handleLogTimeout() {
		 vm_1.$message({message: '请重新登录！',type: 'error'});
		 $("#mainContainer").hide();
		 $(".log-page").show() 
	  }
    },
	created: function(){
          this.actionLoading = true
		  $.ajax({
            type : "GET",
            dataType: "JSON",
            url : "http://localhost:22006/svn/api/product/_searchAll",
			headers: {token: JSON.parse(window.sessionStorage.getItem('accountInfo')).token || ""},
            success : function(result) {
			   vm_1.actionLoading = false
			   if(result.status != 0) {return}
			   vm_1.productTable.tableData = result.data
			   vm_1.productTable.totalSize = result.data.length
            },
            error : function(e){
			    vm_1.actionLoading = false
                console.log(e);
            }
          });	 
	}
  });



});