<template>
  <div>
    <el-row>
      <el-col :span="24">
        <admin-breadcrumb></admin-breadcrumb>
      </el-col>
    </el-row>
    <el-row :gutter="10">
      <el-col :xs="24" :sm="12">
        <el-card>
          <h3 slot="header">管理类目属性模板</h3>
          <el-cascader
            class="category-selector"
            :options="options"
            v-model="selectedOptions"
            @change="handleChange">
          </el-cascader>
          <el-table
            :data="templates"
            border
            style="width: 100%">
            <el-table-column
              label="模板类型"
              width="100">
              <template scope="table">
                <el-tag type="success">{{table.row.attributeType}}</el-tag>
              </template>
            </el-table-column>
            <el-table-column
              prop="name"
              label="模板名称"
              width="180">
            </el-table-column>
            <el-table-column
              prop="categoryId"
              label="所属类目"
              width="180">
            </el-table-column>
            <el-table-column
              label="操作"
              width="180">
              <template scope="scope">
                <el-button
                  type="primary"
                  size="small"
                  icon="edit"
                  @click="handleTemplateEdit(scope.$index, scope.row)">编辑</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-card>
      </el-col>

      <el-col :span="12">
        <el-card>
          <h3 slot="header">编辑类目属性模板</h3>
          <el-form :label-position="'right'" label-width="100px" :model="newCategory" ref="cateForm" :rules="rules">
            <input type="hidden" v-model="newCategory.parentId"/>
            <el-form-item label="模板名称">
              <el-input v-model="newTemplate.name" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="所属类目">
              <el-input v-model="newTemplate.categoryName" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="属性类型">
              <el-tag type="success">搜索属性</el-tag>
            </el-form-item>
            <el-form-item label="属性列表">
              <el-table
                :data="attributeList"
                border
                style="width: 100%">
                <el-table-column
                  label="属性名称"
                  width="100">
                  <template scope="table">
                    <el-input v-model="attributeList[table.$index].attribute"></el-input>
                  </template>
                </el-table-column>
                <el-table-column
                  label="录入方式"
                  width="180">
                  <template scope="table">
                    <el-radio-group v-model="table.row.inputType">
                      <el-radio label="1">选择</el-radio>
                      <el-radio label="2">输入</el-radio>
                    </el-radio-group>
                  </template>
                </el-table-column>
                <el-table-column
                  prop="categoryName"
                  label="所属类目"
                  width="180">
                </el-table-column>
              </el-table>

            </el-form-item>
          </el-form>
          <el-button @click="saveNode">保存</el-button>
        </el-card>
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
        }

      ],
      rules: {
        name: { required: true, message: '请输入类目名称', trigger: 'blur' },
        parentName: { required: true, message: '请选择父级类目', trigger: 'blur' }
      }
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

    toggleAsRoot (state) {
      if (state === true) {
        this.newCategory.parentId = -1
        this.newCategory.parentName = ''
        this.rules.parentName.required = false
      } else {
        this.rules.parentName.required = true
      }
    },

    saveNode () {
      this.$refs['cateForm'].validate((valid) => {
        if (valid) {
          this.addCategory({
            id: this.mockId++,
            name: this.newCategory.name,
            parentId: this.newCategory.parentId
          })
          .then(() => {
            this.newCategory.name = ''
            this.$refs['categoryTree'].$forceUpdate()
          })
          // this.newCategory.name = ''
        } else {
          return false
        }
      })
    },

    toggleCategoryNode (data, node, tree) {
      this.newCategory.parentId = data.id
      if (data.id === -1) {
        this.newCategory.parentName = '顶级类目'
      } else {
        this.newCategory.parentName = data.name
      }
    },

    handleChange (value) {
      console.log(value)
    },

    handleTemplateEdit (index, template) {
      console.log(index, template)
    }
  }
}
</script>
