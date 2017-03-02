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
          <h3 slot="header">商品类目</h3>
          <el-tree ref="categoryTree"
            :data="categoryList"
            :props="{label: 'name'}"
            :default-expand-all="expandAll"
            node-key="id"
            @node-click="toggleCategoryNode">
          </el-tree>

          <ul>
            <li v-for="cate in categoryList">
              {{cate.name}}
              <ul v-if="cate.children && cate.children.length > 0">
                <li v-for="child in cate.children">{{child.name}}</li>
              </ul>
            </li>
          </ul>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12">
        <el-card>
          <h3 slot="header">添加类目</h3>
          <el-form :label-position="'right'" label-width="100px" :model="newCategory" ref="cateForm" :rules="rules">
            <input type="hidden" v-model="newCategory.parentId"/>
            <el-form-item label="顶级类目">
              <el-switch v-model="asRoot" on-text="是" off-text="否" @change="toggleAsRoot"></el-switch>
            </el-form-item>
            <template v-if="!asRoot">
              <el-form-item label="父级类目" prop="parentName">
                <el-input v-model="newCategory.parentName" :disabled="true">
                </el-input>
              </el-form-item>
            </template>
            <el-form-item label="类目名称" prop="name">
              <el-input v-model="newCategory.name"></el-input>
            </el-form-item>
          </el-form>
          <el-button @click="saveNode">保存</el-button>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<style>
</style>
<script>
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
      rules: {
        name: { required: true, message: '请输入类目名称', trigger: 'blur' },
        parentName: { required: true, message: '请选择父级类目', trigger: 'blur' }
      }
    }
  },

  computed: mapGetters([
    'categoryList'
  ]),

  methods: {
    ...mapActions([
      'addCategory'
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
        console.log(this.$refs['categoryTree'])
        console.log('submit!', this.newCategory)
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
          console.log('invalid')
          return false
        }
      })
    },

    toggleCategoryNode (data, node, tree) {
      console.log(data, node, tree)
      this.newCategory.parentId = data.id
      if (data.id === -1) {
        this.newCategory.parentName = '顶级类目'
      } else {
        this.newCategory.parentName = data.name
      }
    }
  }
}
</script>
