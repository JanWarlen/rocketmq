/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.acl;

import java.util.List;
import java.util.Map;

import org.apache.rocketmq.common.AclConfig;
import org.apache.rocketmq.common.DataVersion;
import org.apache.rocketmq.common.PlainAccessConfig;
import org.apache.rocketmq.remoting.protocol.RemotingCommand;

public interface AccessValidator {

    /**
     * Parse to get the AccessResource(user, resource, needed permission)
     * 从请求头中解析本次请求对应的访问资源，即本次请求需要的访问权限
     * @param request
     * @param remoteAddr
     * @return Plain access resource result,include access key,signature and some other access attributes.
     */
    AccessResource parse(RemotingCommand request, String remoteAddr);

    /**
     * Validate the access resource.
     * 根据本次需要访问的权限，与请求用户拥有的权限对比，判断用户是否拥有权限，如果没有则抛出异常，有则放行
     * @param accessResource
     */
    void validate(AccessResource accessResource);

    /**
     * Update the access resource config
     * 更新 ACL 控制访问列表配置
     * @param plainAccessConfig
     * @return
     */
    boolean updateAccessConfig(PlainAccessConfig plainAccessConfig);

    /**
     * Delete the access resource config
     * 删除 ACL 控制访问列表配置
     * @return
     */
    boolean deleteAccessConfig(String accesskey);

    /**
     * Get the access resource config version information
     * 获取当前 ACL 控制访问列表版本号
     * @return
     */
    @Deprecated
    String getAclConfigVersion();

    /**
     * Update globalWhiteRemoteAddresses in acl yaml config file
     * 更新全局白名单IP列表
     * @return
     */
    boolean updateGlobalWhiteAddrsConfig(List<String> globalWhiteAddrsList);

    boolean updateGlobalWhiteAddrsConfig(List<String> globalWhiteAddrsList, String aclFileFullPath);

    /**
     * get broker cluster acl config information
     * 获取 ACL 相关的配置信息
     * @return
     */
    AclConfig getAllAclConfig();

    /**
     * get all access resource config version information
     *
     * @return
     */
    Map<String, DataVersion> getAllAclConfigVersion();
}
