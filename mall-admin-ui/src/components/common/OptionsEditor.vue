<template>
  <div class="option-editor el-table el-table--border el-table--enable-row-hover">
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
          <div class="cell">操作</div>
        </th>
      </tr>
      </thead>
      <draggable element="tbody" v-model="editableOptions" :options="dragOptions">
        <tr v-for="opt in editableOptions" class="sortable-option">
          <td>
            <el-input class="option-input" v-model="opt.option" v-on:change="testTable(opt)"></el-input>
          </td>
          <td>
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
          </td>
          <td>{{opt.initial}}</td>
          <td>
            <el-button v-if="opt.optionImage" :plain="true" type="danger" icon="delete" size="small" v-on:click="removeOptionImage(opt)">移除图片</el-button>
            <el-button class="drag-handler" :plain="true" type="primary" icon="d-caret" size="small"></el-button>
          </td>
        </tr>
      </draggable>
    </table>
  </div>
</template>

<script type="text/babel">
import draggable from 'vuedraggable'

export default{
  components: {
    draggable
  },
  props: {
    options: Array
  },
  data () {
    return {
      dragOptions: {
        draggable: '.sortable-option',
        handle: '.drag-handler'
      },
      editableOptions: this.options,
      msg: 'hello vue'
    }
  },

  methods: {
    handleChange (value) {
      console.log(value)
    },

    handleOptionImageSuccess (option) {
      return (res, file) => {
        option.optionImage = window.URL.createObjectURL(file.raw)
        console.log('end:', option)
      }
    },

    testTable (row) {
      console.log(row)
    },

    removeOptionImage (option) {
      option.optionImage = ''
    }
  }
}
</script>
<style lang="scss" scoped>
  $uploader-width: 50px;
  $uploader-margin: 5px;

  .option-editor {
    .drag-handler.el-button {
      cursor: move;
    }

    table td {
      text-align: center;
    }

    .option-input {
      width: 90%;
    }

    .option-img-uploader {

      border: 1px dashed #d9d9d9;
      border-radius: 6px;
      cursor: pointer;
      position: relative;
      overflow: hidden;
      width: $uploader-width;
      height: $uploader-width;
      line-height: $uploader-width;
      margin: $uploader-margin auto;

      &:hover {
        border-color: #20a0ff;
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
  }
  .option-img {
    width: $uploader-width;
    height: $uploader-width;
    display: inline-block;
  }

  .option-img-delete {
    line-height: $uploader-width + ($uploader-margin * 2)
  }
</style>
