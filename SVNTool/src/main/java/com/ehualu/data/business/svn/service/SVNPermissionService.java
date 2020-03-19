package com.ehualu.data.business.svn.service;

import com.ehualu.data.business.svn.model.FilePermission;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author created by guanchen on 2020/3/16 16:19
 */
@Service
public class SVNPermissionService {

    public  void addPermission2File(String permissionFile,String file,List<String> userNameList,String access){
        if (FilePermission.NONE.getCode().equals(access)){
            //删除权限
            return;
        }
        try {
            List<String> permissonLines = Files.lines(Paths.get(permissionFile))
                    .collect(java.util.stream.Collectors.toList());
            permissonLines.add("[" + file + "]");
            userNameList.stream().forEach(userName -> {
                permissonLines.add(userName + "=" + access);
            });

            Files.write(Paths.get(permissionFile), permissonLines, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deletePermission(String permissionFile,String file){
        try {
            List<String> permissonLines = Files.lines(Paths.get(permissionFile))
                    .collect(java.util.stream.Collectors.toList());

            StringBuilder resultLines = new StringBuilder();
            AtomicBoolean doDelete = new AtomicBoolean(false);
            permissonLines.stream().forEach(line -> {
                if (doDelete.get() && !line.contains("[") && !line.contains("]")){
                    //目标文件标识下用户权限，不写入文件
                    return;
                }
                if (line.contains(file)){
                    //发现目标文件标识，不写入文件
                    doDelete.set(true);
                    return;
                }

                doDelete.set(false);
                resultLines.append(line).append(System.getProperty("line.separator"));
            });
            Files.write(Paths.get(permissionFile), resultLines.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String passwdFile, String userCMD){

        try {
            List<String> permissonLines = Files.lines(Paths.get(passwdFile))
                    .collect(java.util.stream.Collectors.toList());
            permissonLines.add(userCMD);

            Files.write(Paths.get(passwdFile), permissonLines,
                    Charset.defaultCharset(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
