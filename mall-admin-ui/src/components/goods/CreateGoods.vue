<template>
  <div>
    <el-row>
      <el-col :span="24">
        <admin-breadcrumb></admin-breadcrumb>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="18" :offset="3">
        <el-form ref="create-goods-form" :model="goodsInfo" label-width="80px">
          <el-form-item label="商品分类">
            <el-cascader
              class="category-selector"
              :options="options"
              v-model="selectedOptions"
              @change="handleChange">
            </el-cascader>
          </el-form-item>
          <el-form-item label="品牌">
            <el-select v-model="goodsInfo.brand.name" placeholder="请选择品牌">
              <el-option label="品牌一" value="apple"></el-option>
              <el-option label="品牌二" value="huawei"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="onSubmit">立即创建</el-button>
            <el-button>取消</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>
  </div>
</template>
<style lang="scss" scoped>

</style>
<script type="text/babel">
export default{
  data () {
    return {
      goodsInfo: {
        brand: {
          name: ''
        }
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
      ]
    }
  },

  methods: {
    handleChange (value) {
      console.log(value)
    },

    onSubmit () {
      console.log(this.goodsInfo)
    }
  }
}

</script>
