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

<template>
  <div>
    <a-list size="small" :dataSource="details">
      <template #renderItem="{item}">
        <a-list-item>
          <div>
            <strong>{{ $t(`label.${item}`) }}</strong>
            <br />
            <div v-if="item === 'servicelist'">
              {{ nsp[item] ? nsp[item].join(', ') : '' }}
            </div>
            <span v-else-if="item !== 'state'">{{ nsp[item] ? nsp[item] : '' }}</span>
            <span v-else>
              <status :text="nsp[item] ? nsp[item] : 'Disabled'" displayText />
            </span>
          </div>
        </a-list-item>
      </template>
    </a-list>
  </div>
</template>

<script>
import Status from '@/components/widgets/Status'

export default {
  name: 'ProviderDetail',
  components: {
    Status
  },
  props: {
    details: {
      type: Array,
      default: () => []
    },
    nsp: {
      type: Object,
      default: () => {}
    }
  }
}
</script>

<style scoped>
</style>
