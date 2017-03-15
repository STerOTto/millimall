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

                <div class="el-table el-table--border el-table--enable-row-hover el-table--enable-row-transition">
                  <table width="100%">
                    <thead>
                    <tr>
                      <th class="is-leaf">
                        <div class="cell">选项名称</div>
                      </th>
                      <th class="is-leaf">
                        <div class="cell">选项图片</div>
                      </th>
                      <th class="is-leaf">
                        <div class="cell">选项首字母</div>
                      </th>
                      <th class="is-leaf">
                        <div class="cell">选项序号</div>
                      </th>
                    </tr>
                    </thead>
                    <draggable element="tbody" v-model="attr.options" :options="dragOptions">
                      <tr v-for="opt in attr.options" class="sortable-option">
                        <td>
                          <el-input v-model="opt.option" v-on:change="testTable(opt)"></el-input>
                        </td>
                        <td>
                          <el-row>
                            <el-col :span="12">
                              <el-upload
                                class="option-img-uploader"
                                action="//jsonplaceholder.typicode.com/posts/"
                                :show-file-list="false"
                                :on-success="handleOptionImageSuccess(opt)">
                                <template v-if="opt.optionImage">
                                  <img :src="opt.optionImage" class="option-img">
                                </template>
                                <template v-else>
                                  <i class="el-icon-plus option-img-uploader-icon"></i>
                                </template>
                              </el-upload>
                            </el-col>
                            <el-col :span="12">
                              <div class="option-img-delete">
                                <el-button v-if="opt.optionImage" type="danger" icon="delete" size="mini">刪除</el-button>
                              </div>
                            </el-col>
                          </el-row>
                        </td>
                        <td>{{opt.initial}}</td>
                        <td align="center">
                          <div class="drag-handler">
                            <el-button type="primary" icon="d-caret" size="small">拖拽</el-button>
                          </div>
                        </td>
                      </tr>
                    </draggable>
                  </table>
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
<style lang="scss">
  $uploader-width: 50px;
  $uploader-margin: 5px;

  .category-selector {
    margin-bottom: 20px;
  }
  ul.edit-options-sort {
    margin: 0;
    padding: 0;
    li.sortable-option {
      list-style-type: none;
      border: 1px solid #989898;
      padding:5px 10px;
      &:last-child {
        margin-top: -1px;
      }
    }
  }
  .option-img {
    width: $uploader-width;
    height: $uploader-width;
    display: inline-block;
  }
  .option-img-uploader {
    .el-upload {
      border: 1px dashed #d9d9d9;
      border-radius: 6px;
      cursor: pointer;
      position: relative;
      overflow: hidden;
      width: $uploader-width;
      height: $uploader-width;
      line-height: $uploader-width;
      margin: $uploader-margin;
      &:hover {
        border-color: #20a0ff;
      }
    }
    .option-img-uploader-icon {
      font-size: 15px;
      color: #8c939d;
      width: $uploader-width;
      height: $uploader-width;
      line-height: $uploader-width;
      text-align: center;
    }
  }
  .option-img-delete {
    line-height: $uploader-width + ($uploader-margin * 2)
  }
</style>
<script type="text/babel">
import { mapGetters, mapActions } from 'vuex'
import draggable from 'vuedraggable'

export default {
  components: {
    draggable
  },
  data () {
    return {
      expandAll: false,
      mockId: 1,
      asRoot: false,
      activeTab: 'first',
      activeAttributes: '1',
      dragOptions: {
        draggable: '.sortable-option'
      },
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
              optionImage: '',
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

    handleOptionImageSuccess (option) {
      console.log('handleOptionImageSuccess call', option)
      return (res, file) => {
        option.optionImage = window.URL.createObjectURL(file.raw)
        console.log('end:', option)
      }
    },

    testTable (row) {
      console.log(row)
    }
  }
}
</script>
