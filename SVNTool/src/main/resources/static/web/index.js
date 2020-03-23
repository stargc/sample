$(document).ready(function(){
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
			  if(result.errorCode == 0){
			    var token = result.data || ""
				window.sessionStorage.setItem("accountInfo", token);
			    vm.$message({message: '登录成功！',type: 'success'})	
				vm_1.userName = name
			    $(".log-page").hide()
			    $("#mainContainer").show();
				}
			  else {
				  vm.$message({message: result.error,type: 'error'});
				  return false
			  }
            },
            error : function(e){
				vm.loading = false
				vm.$message({message: '登录失败！',type: 'error'});
                console.log(e.responseText);
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
		activeIndex: "1",
        activeName: 'first',
		userName:"",
		productOptions: [],
		productValue: "",
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
		actionLoading: false
		
      };
    },
    methods: {
	  handleSelect(key, keyPath) {
		  this.activeIndex=parseInt(key);
	      vm_1.productValue = ""
		  vm_1.selectedUser= []
		  vm_1.timeValue = ""
		  vm_1.exportCode = ""
		  vm_1.exportName = ""
		  vm_1.realNameInput = ""
	  },
	  exportProduct() {
		var data = {
			"productId": this.productValue,
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
			headers: {token: window.sessionStorage.getItem('accountInfo') || ""},
            success : function(result) {
			  vm_1.actionLoading = false
			   if(result.status != 0) {
				   vm_1.$message({message: result.error,type: 'error'});
				   return
				}			  
			  vm_1.$message({message: '出库成功！',type: 'success'});
            },
            error : function(e){
		      vm_1.actionLoading = false
	          vm_1.$message({message: '出库失败！',type: 'error'});
            }
          });		
	  },
	  bindName() {
		this.actionLoading = true 
		var data = { "id":this.selectedUser.join(","),
					 "realName":this.realNameInput
				}
          $.ajax({
            type : "POST",
            contentType: "application/json;charset=UTF-8",
            url : "http://localhost:22006/svn/api/svnuser/updateUser",
			data: JSON.stringify(data),
			headers: {token: window.sessionStorage.getItem('accountInfo') || ""},
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
			"userId":vm_1.selectedUser.join(","),
			"productId":vm_1.productValue,
			"projectCode":vm_1.exportCode,
			"index":vm_1.currentPage,
			"num":vm_1.pageSize
			}  
		vm_1.actionLoading = true
          $.ajax({
            type : "POST",
            contentType: "application/json;charset=UTF-8",
            url : "http://localhost:22006/svn/api/delivery/_search",
			data: JSON.stringify(data),
			headers: {token: window.sessionStorage.getItem('accountInfo') || ""},
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
	  getProduct() {this.productOptions.length = 0;
   	      this.selectLoading = true
          $.ajax({
            type : "GET",
            dataType: "JSON",
            url : "http://localhost:22006/svn/api/product/_searchAll",
			headers: {token: window.sessionStorage.getItem('accountInfo') || ""},
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
			headers: {token: window.sessionStorage.getItem('accountInfo') || ""},
            success : function(result) {
			   vm_1.selectLoading = false
			   if(result.status != 0) {return}
			   for(var item of result.data){
                 vm_1.userOptions.push({
				  value: item.id,
				  label: item.userName
				 })
			   }
            },
            error : function(e){
				vm_1.selectLoading = false
                console.log(e);
            }
          });	    	  
	  },
      handleCurrentChange(val) {
		  this.currentPage = val;
		  this.search();
      },
	  handleLogTimeout() {
		 vm_1.$message({message: '请重新登录！',type: 'error'});
		 $("#mainContainer").hide();
		 $(".log-page").show() 
	  }
    }
  });



});