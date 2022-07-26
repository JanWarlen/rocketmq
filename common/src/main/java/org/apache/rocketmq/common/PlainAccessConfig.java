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
package org.apache.rocketmq.common;

import java.util.List;

public class PlainAccessConfig {

    /**
     * 登录用户名
     */
    private String accessKey;

    /**
     * 登录密码
     */
    private String secretKey;

    /**
     * 账户级别的IP地址白名单，但只能配置一条
     */
    private String whiteRemoteAddress;

    /**
     * 是否是超级管理员，true/false
     */
    private boolean admin;

    /**
     * 默认topic权限
     */
    private String defaultTopicPerm;

    /**
     * 默认消费组权限
     */
    private String defaultGroupPerm;

    /**
     * 设置指定topic的权限，针对指定topic，DENY 拒绝，PUB 发送权限，SUB 订阅权限
     * topicA=DENY
     * topicB=PUB|SUB
     * topicC=SUB
     */
    private List<String> topicPerms;

    /**
     * 针对指定消费组设置权限
     * groupA=DENY
     * groupB=PUB|SUB
     * groupC=SUB
     */
    private List<String> groupPerms;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getWhiteRemoteAddress() {
        return whiteRemoteAddress;
    }

    public void setWhiteRemoteAddress(String whiteRemoteAddress) {
        this.whiteRemoteAddress = whiteRemoteAddress;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getDefaultTopicPerm() {
        return defaultTopicPerm;
    }

    public void setDefaultTopicPerm(String defaultTopicPerm) {
        this.defaultTopicPerm = defaultTopicPerm;
    }

    public String getDefaultGroupPerm() {
        return defaultGroupPerm;
    }

    public void setDefaultGroupPerm(String defaultGroupPerm) {
        this.defaultGroupPerm = defaultGroupPerm;
    }

    public List<String> getTopicPerms() {
        return topicPerms;
    }

    public void setTopicPerms(List<String> topicPerms) {
        this.topicPerms = topicPerms;
    }

    public List<String> getGroupPerms() {
        return groupPerms;
    }

    public void setGroupPerms(List<String> groupPerms) {
        this.groupPerms = groupPerms;
    }
}
