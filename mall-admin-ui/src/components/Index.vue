<template>
  <div class="hello">

    <div class="console-sidebar">

      <el-menu default-active="2" @open="handleOpen" @close="handleClose">
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-message"></i>导航一</template>
          <el-menu-item-group>
            <template slot="title">分组一</template>
            <el-menu-item index="1-1">选项1</el-menu-item>
            <el-menu-item index="1-2">选项2</el-menu-item>
          </el-menu-item-group>
          <el-menu-item-group title="分组2">
            <el-menu-item index="1-3">选项3</el-menu-item>
          </el-menu-item-group>
          <el-submenu index="1-4">
            <template slot="title">选项4</template>
            <el-menu-item index="1-4-1">选项1</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-menu-item index="2"><i class="el-icon-menu"></i>导航二</el-menu-item>
        <el-menu-item index="3"><i class="el-icon-setting"></i>导航三</el-menu-item>
      </el-menu>
    </div>

    <div class="console-topbar">
      <TopNav></TopNav>
      <el-row>
        <router-view></router-view>
      </el-row>
    </div>
  </div>
</template>

<script>
  import router from '../routes'
  import TopNav from './TopNav'

  export default {
    components: { TopNav },
    name: 'hello',
    data () {
      return {
        msg: 'Welcome to Your Vue.js App',
        activeIndex: '1',
        activeIndex2: '1'
      }
    },
    methods: {
      httpTest () {
        this.$http.get('https://api.github.com/users/johntostring')
          .then(response => {
            console.log(response)
          })
          .catch(error => {
            console.log(error)
          })
      },
      logoff () {
        window.sessionStorage.setItem('isAuthenticated', 'false')
        router.replace('/login')
      },
      handleOpen (key, keyPath) {
        console.log(key, keyPath)
      },
      handleClose (key, keyPath) {
        console.log(key, keyPath)
      },
      handleSelect (key, keyPath) {
        console.log(key, keyPath)
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
  .console-topbar {
    margin-left: 230px;
  }
  .console-sidebar .logo {
    display: inline-block;
    vertical-align: middle;
    height: 60px;
  }
  .sidebar-header {
    text-align: center;
  }
  .console-sidebar {
    position: absolute;
    width: 230px;
    top: 60px;
    bottom: 0;
    background: #eef1f6;
  }
  a {
    color: #42b983;
  }
</style>
