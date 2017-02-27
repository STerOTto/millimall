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
          <el-tree ref="tree"
            :data="categoryList"
            node-key="id"
            @node-click="toggleCategoryNode">
          </el-tree>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="12">
        <el-card>
          <h3 slot="header">添加类目</h3>
          <el-form :label-position="'right'" label-width="100px" :model="newCategory" ref="cateForm" :rules="rules">
            <el-form-item label="父级ID">
              <el-input-number size="small" v-model="newCategory.parentId" :disabled="true"></el-input-number>
            </el-form-item>
            <el-form-item label="父级分类" prop="parentName">
              <el-input v-model="newCategory.parentName" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="分类名称" prop="name">
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
  export default {

    data () {
      return {
        newCategory: {
          name: '',
          parentId: -1,
          parentName: ''
        },
        categoryList: [{
          id: -1,
          label: '顶级分类'
        }],
        rules: {
          name: { required: true, message: '请输入分类名称', trigger: 'blur' },
          parentName: { required: true, message: '请选择父级分类', trigger: 'blur' }
        }
      }
    },
    methods: {
      saveNode () {
        this.$refs['cateForm'].validate((valid) => {
          console.log('submit!', this.newCategory)
          if (valid) {
            console.log('valid')
          } else {
            console.log('invalid')
            return false
          }
        })
      },
      toggleCategoryNode (data, node, tree) {
        this.newCategory.parentId = data.id
        if (data.id === -1) {
          this.newCategory.parentName = '顶级分类'
        } else {
          this.newCategory.parentName = data.label
        }
      }
    }
  }
</script>
