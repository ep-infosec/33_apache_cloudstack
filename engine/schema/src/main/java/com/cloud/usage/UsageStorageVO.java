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
package com.cloud.usage;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.cloudstack.api.InternalIdentity;

@Entity
@Table(name = "usage_storage")
public class UsageStorageVO implements InternalIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "zone_id")
    private long zoneId;

    @Column(name = "account_id")
    private long accountId;

    @Column(name = "domain_id")
    private long domainId;

    @Column(name = "entity_id")
    private long entityId;

    @Column(name = "storage_type")
    private int storageType;

    @Column(name = "source_id")
    private Long sourceId;

    @Column(name = "size")
    private long size;

    @Column(name = "created")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date created = null;

    @Column(name = "deleted")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date deleted = null;

    @Column(name = "virtual_size")
    private Long virtualSize;

    protected UsageStorageVO() {
    }

    public UsageStorageVO(long id, long zoneId, long accountId, long domainId, int storageType, Long sourceId, long size, Date created, Date deleted) {
        this.zoneId = zoneId;
        this.accountId = accountId;
        this.domainId = domainId;
        this.entityId = id;
        this.storageType = storageType;
        this.sourceId = sourceId;
        this.size = size;
        this.created = created;
        this.deleted = deleted;
    }

    public UsageStorageVO(long id, long zoneId, long accountId, long domainId, int storageType, Long sourceId, long size, Long virtualSize, Date created, Date deleted) {
        this.zoneId = zoneId;
        this.accountId = accountId;
        this.domainId = domainId;
        this.entityId = id;
        this.storageType = storageType;
        this.sourceId = sourceId;
        this.size = size;
        this.virtualSize = virtualSize;
        this.created = created;
        this.deleted = deleted;
    }

    public long getZoneId() {
        return zoneId;
    }

    public long getAccountId() {
        return accountId;
    }

    public long getDomainId() {
        return domainId;
    }

    @Override
    public long getId() {
        return id;
    }

    public int getStorageType() {
        return storageType;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public long getSize() {
        return size;
    }

    public Long getVirtualSize() {
        return virtualSize;
    }

    public Date getCreated() {
        return created;
    }

    public Date getDeleted() {
        return deleted;
    }

    public void setDeleted(Date deleted) {
        this.deleted = deleted;
    }

    public long getEntityId() {
        return entityId;
    }
}
