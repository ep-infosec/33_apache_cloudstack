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
package org.apache.cloudstack.diagnostics;

import org.apache.cloudstack.storage.command.StorageSubSystemCommand;

public class CopyToSecondaryStorageCommand extends StorageSubSystemCommand {
    private String secondaryStorageUrl;
    private String systemVmIp;
    private String fileName;
    private String nfsVersion;

    public CopyToSecondaryStorageCommand(String secondaryStorageUrl, String systemVmIp, String fileName, String nfsVersion) {
        this.secondaryStorageUrl = secondaryStorageUrl;
        this.systemVmIp = systemVmIp;
        this.fileName = fileName;
        this.nfsVersion = nfsVersion;
    }

    public String getSecondaryStorageUrl() {
        return secondaryStorageUrl;
    }

    public String getSystemVmIp() {
        return systemVmIp;
    }

    public String getFileName() {
        return fileName;
    }

    public String getNfsVersion() {
        return nfsVersion;
    }

    @Override
    public boolean executeInSequence() {
        return false;
    }

    @Override
    public void setExecuteInSequence(boolean inSeq) {

    }
}
