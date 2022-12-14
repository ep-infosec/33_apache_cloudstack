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
  <div :style="!$route.meta.pageHeader ? 'margin: -24px -24px 0px;' : null">
    <!-- pageHeader , route meta hideHeader:true on hide -->
    <page-header v-if="!$route.meta.pageHeader" :title="title" :logo="logo" :avatar="avatar">
      <template #action><slot name="action"></slot></template>
      <template #content><slot name="headerContent"></slot></template>
      <template #slot:content v-if="!this.$slots.headerContent && desc">
        <p style="font-size: 14px;color: rgba(0,0,0,.65)">{{ desc }}</p>
        <div class="link">
          <template v-for="(link, index) in linkList" :key="index">
            <a :href="link.href">
              <render-icon v-if="index == 0" :icon="link.icon" />
              <span>{{ link.title }}</span>
            </a>
          </template>
        </div>
      </template>
      <template #extra><slot name="extra"></slot></template>
      <template #pageMenu>
        <div class="page-menu-search" v-if="search">
          <a-input-search style="width: 80%; max-width: 522px;" placeholder="请输入..." size="large" enterButton="搜索" />
        </div>
        <div class="page-menu-tabs" v-if="tabs && tabs.items">
          <!-- @change="callback" :activeKey="activeKey" -->
          <a-tabs :tabBarStyle="{margin: 0}" @change="tabs.callback" :activeKey="tabs.active()">
            <a-tab-pane v-for="item in tabs.items" :tab="item.title" :key="item.key"></a-tab-pane>
          </a-tabs>
        </div>
      </template>
    </page-header>
    <div class="content">
      <div :class="['page-header-index-wide']">
        <slot></slot>
      </div>
    </div>
  </div>
</template>

<script>
import PageHeader from './PageHeader'

export default {
  name: 'LayoutContent',
  components: {
    PageHeader
  },
  // ['desc', 'logo', 'title', 'avatar', 'linkList', 'extraImage']
  props: {
    desc: {
      type: String,
      default: null
    },
    logo: {
      type: String,
      default: null
    },
    title: {
      type: String,
      default: null
    },
    avatar: {
      type: String,
      default: null
    },
    linkList: {
      type: Array,
      default: null
    },
    extraImage: {
      type: String,
      default: null
    },
    search: {
      type: Boolean,
      default: false
    },
    tabs: {
      type: Object,
      default: () => ({})
    }
  },
  methods: {
  }
}
</script>

<style lang="less" scoped>
  .content {
    margin: 24px 24px 0;

    .link {
      margin-top: 16px;

      &:not(:empty) {
        margin-bottom: 16px;
      }
      a {
        margin-right: 32px;
        height: 24px;
        line-height: 24px;
        display: inline-block;

        i {
          font-size: 24px;
          margin-right: 8px;
          vertical-align: middle;
        }
        span {
          height: 24px;
          line-height: 24px;
          display: inline-block;
          vertical-align: middle;
        }
      }
    }
  }
  .page-menu-search {
    text-align: center;
    margin-bottom: 16px;
  }
  .page-menu-tabs {
    margin-top: 48px;
  }
</style>
