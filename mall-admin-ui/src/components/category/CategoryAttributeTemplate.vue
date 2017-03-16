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
            change-on-select
            class="category-selector"
            :props="categoryCascaderProps"
            :options="categories"
            v-model="categories"
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
                <options-editor v-if="attr.inputType == '1'" :options="attr.options"></options-editor>
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
  .category-selector {
    margin-bottom: 20px;
  }
</style>
<script type="text/babel">
import { mapGetters, mapActions } from 'vuex'
import OptionsEditor from '../common/OptionsEditor'

export default {
  components: {
    OptionsEditor
  },
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
      categoryCascaderProps: {
        value: 'id',
        label: 'name'
      },
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

  computed: {
    ...mapGetters({
      categories: 'allCategories'

    })
  },

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
