<template>
  <div>
    <el-row>
      <el-col :span="24">
        <admin-breadcrumb></admin-breadcrumb>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12" :offset="6">
        <el-card>
          <el-tree
            :data="categoryList"
            show-checkbox
            node-key="id"
            :default-expanded-keys="[2, 3]"
            :default-checked-keys="[5]">
          </el-tree>
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
        categoryList: [{
          id: 1,
          label: '一级 1',
          children: [{
            id: 4,
            label: '二级 1-1',
            children: [{
              id: 9,
              label: '三级 1-1-1'
            }, {
              id: 10,
              label: '三级 1-1-2'
            }]
          }]
        }, {
          id: 2,
          label: '一级 2',
          children: [{
            id: 5,
            label: '二级 2-1'
          }, {
            id: 6,
            label: '二级 2-2'
          }]
        }]
      }
    },
    methods: {
      onSubmit () {
        console.log('submit!')
      }
    }
  }
</script>
