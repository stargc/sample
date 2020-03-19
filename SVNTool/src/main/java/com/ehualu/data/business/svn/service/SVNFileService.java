package com.ehualu.data.business.svn.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.tmatesoft.svn.core.SVNCommitInfo;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNProperties;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.wc.SVNClientManager;
import org.tmatesoft.svn.core.wc.SVNCopySource;
import org.tmatesoft.svn.core.wc.SVNRevision;

import java.io.File;

/**
 * @author created by guanchen on 2020/3/18 14:18
 */
@Slf4j
@Service
public class SVNFileService {


    @Autowired
    private SVNClientManager svnClientManager;

    /**
     * 复制-copy
     * @throws SVNException
     */
    public void doCopy(String sourcePath,String dstPath) throws SVNException{
        SVNCopySource svnCopySource1 = new SVNCopySource(SVNRevision.HEAD,SVNRevision.HEAD, SVNURL.parseURIEncoded(sourcePath));
        SVNURL dist = SVNURL.parseURIEncoded(dstPath);
        SVNCommitInfo svnCommitInfo = svnClientManager.getCopyClient().doCopy(new SVNCopySource[]{svnCopySource1},dist,
                false,true,true,"do copy",new SVNProperties());
        log.info(String.format("执行copy操作,从{%s}到{%s},结果：%s",sourcePath,dstPath,JSON.toJSONString(svnCommitInfo)));
    }

    /**
     * 创建目录-mkdir
     * @throws SVNException
     */
    public void doMkDir() throws SVNException{
        SVNURL url = svnClientManager.getAdminClient().doCreateRepository(new File("D:\\SVN\\workbench\\test2"),
                null, true, false);
        log.info("创建svn:" + url.toString());
    }

    /**
     * 删除-delete
     * @throws SVNException
     */
    public void doDelete(String sourcePath) throws SVNException{
        SVNCommitInfo svnCommitInfo = svnClientManager.getCommitClient().doDelete(new SVNURL[]{SVNURL.parseURIEncoded(sourcePath)},"执行删除操作");
        log.info(String.format("{%s}执行delete操作成功，操作结果：",sourcePath,JSON.toJSONString(svnCommitInfo)));
    }

}
