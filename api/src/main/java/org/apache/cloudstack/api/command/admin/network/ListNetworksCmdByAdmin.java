// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package org.apache.cloudstack.api.command.admin.network;

import org.apache.cloudstack.api.APICommand;
import org.apache.cloudstack.api.ApiConstants;
import org.apache.cloudstack.api.Parameter;
import org.apache.cloudstack.api.ResponseObject.ResponseView;
import org.apache.cloudstack.api.command.admin.AdminCmd;
import org.apache.cloudstack.api.command.user.network.ListNetworksCmd;
import org.apache.cloudstack.api.response.NetworkResponse;

import com.cloud.network.Network;

@APICommand(name = "listNetworks", description = "Lists all available networks.", responseObject = NetworkResponse.class, responseView = ResponseView.Full, entityType = {Network.class},
        requestHasSensitiveInfo = false, responseHasSensitiveInfo = false)
public class ListNetworksCmdByAdmin extends ListNetworksCmd implements AdminCmd {

    @Parameter(name= ApiConstants.VLAN, type=CommandType.STRING, description="the ID or VID of the network", since = "4.17.0")
    private String vlan;

    /////////////////////////////////////////////////////
    /////////////////// Accessors ///////////////////////
    /////////////////////////////////////////////////////

    public String getVlan() {
        return vlan;
    }
}
