<template>
  <div>
    <el-row>
      <el-col :span="24">
        <admin-breadcrumb></admin-breadcrumb>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12" :offset="6">
        <div style="text-align:center">
          <span>类目：</span>
          <el-cascader
            class="category-selector"
            :options="options"
            v-model="selectedOptions"
            @change="handleChange">
          </el-cascader>
        </div>
      </el-col>
    </el-row>
    <el-row :gutter="10">

      <el-col :xs="24">
        <el-tabs v-model="activeTab">
          <el-tab-pane label="搜索属性模板" name="first">
            <el-collapse v-model="activeAttributes" @change="handleChange">
              <el-collapse-item v-for="attr in attributeList" :title="attr.attribute" :name="attr.attribute">
                <div class="el-form-item">
                  <label class="el-form-item__label">录入方式：</label>
                  <div class="el-form-item__content">
                    <el-radio-group v-model="attr.inputType">
                      <el-radio label="1">选择</el-radio>
                      <el-radio label="2">输入</el-radio>
                    </el-radio-group>
                  </div>
                </div>
                <div>
                  <el-table
                    v-if="attr.inputType == '1'"
                    :data="attr.options"
                    border
                    style="width: 100%">
                    <el-table-column
                      label="选项名称">
                      <template scope="table">
                        <el-input v-model="table.row.option"></el-input>
                      </template>
                    </el-table-column>
                    <el-table-column
                      label="选项图片"
                      width="180">
                      <template scope="table">
                        <el-upload
                          class="avatar-uploader"
                          action="//jsonplaceholder.typicode.com/posts/"
                          :show-file-list="false"
                          :on-success="handleOptionImageSuccess">
                          <img v-if="table.row.optionImage" :src="table.row.optionImage" class="avatar">
                          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                        </el-upload>
                      </template>
                    </el-table-column>
                    <el-table-column
                      label="选项首字母"
                      prop="initial">
                    </el-table-column>
                    <el-table-column
                      label="选项序号"
                      prop="ordinal"
                      width="180">
                    </el-table-column>
                  </el-table>
                </div>
              </el-collapse-item>
            </el-collapse>
          </el-tab-pane>

          <el-tab-pane label="规格属性模板" name="second">配置管理</el-tab-pane>

          <el-tab-pane label="SKU属性模板" name="third">角色管理</el-tab-pane>
        </el-tabs>
      </el-col>

    </el-row>
  </div>
</template>
<style lang="scss" scoped>
  .category-selector {
    margin-bottom: 20px;
  }
</style>
<script type="text/babel">
import { mapGetters, mapActions } from 'vuex'

export default {

  data () {
    return {
      expandAll: false,
      mockId: 1,
      asRoot: false,
      activeTab: 'first',
      activeAttributes: '1',
      newCategory: {
        name: '',
        parentId: -1,
        parentName: ''
      },
      newTemplate: {
        name: null,
        attributeType: null,
        categoryId: null,
        categoryName: null
      },
      selectedOptions: [],
      options: [
        {
          value: 'zhinan',
          label: '指南',
          children: [
            {
              value: 'shejiyuanze',
              label: '设计原则',
              children: [
                {
                  value: 'yizhi',
                  label: '一致'
                },
                {
                  value: 'fankui',
                  label: '反馈'
                },
                {
                  value: 'xiaolv',
                  label: '效率'
                },
                {
                  value: 'kekong',
                  label: '可控'
                }
              ]
            },
            {
              value: 'daohang',
              label: '导航',
              children: [
                {
                  value: 'cexiangdaohang',
                  label: '侧向导航'
                },
                {
                  value: 'dingbudaohang',
                  label: '顶部导航'
                }
              ]
            }
          ]
        }
      ],
      templates: [
        {
          name: '搜索属性模板',
          attributeType: '搜索属性'
        },
        {
          name: '规格属性模板',
          attributeType: '规格属性'
        },
        {
          name: 'SKU属性模板',
          attributeType: 'SKU属性'
        }
      ],
      attributeList: [
        {
          attribute: '颜色',
          inputType: '1',
          options: [
            {
              option: '红色',
              optionImage: '/path/to/color',
              initial: 'H',
              ordinal: 1
            },
            {
              option: '蓝色',
              optionImage: '/path/to/color',
              initial: 'L',
              ordinal: 2
            }
          ]
        },
        {
          attribute: '尺寸',
          inputType: '1',
          options: [
            {
              option: 'S',
              optionImage: '/path/to/color',
              initial: 'H',
              ordinal: 1
            },
            {
              option: 'M',
              optionImage: '/path/to/color',
              initial: 'L',
              ordinal: 2
            }
          ]
        }

      ]
    }
  },

  computed: mapGetters({
    categories: 'allCategories'
  }),

  created () {
    this.getCategoryList()
  },

  methods: {
    ...mapActions([
      'addCategory',
      'getCategoryList'
    ]),

    handleChange (value) {
      console.log(value)
    },

    handleTemplateEdit (index, template) {
      console.log(index, template)
    },

    handleOptionImageSuccess (res, file) {
      console.log(res, file)
      // this.imageUrl = window.URL.createObjectURL(file.raw)
    }
  }
}
</script>
