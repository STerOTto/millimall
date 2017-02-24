<template>
  <div class="nav">
    <img src="../assets/logo.png" class="logo">
    <el-menu theme="dark" class="right" mode="horizontal">
      <el-submenu index="2">
        <template slot="title">我的工作台</template>
        <el-menu-item index="2-1">选项1</el-menu-item>
        <el-menu-item index="2-2">选项2</el-menu-item>
        <el-menu-item index="2-3">选项3</el-menu-item>
      </el-submenu>
    </el-menu>
  </div>
</template>
<script>
  export default {
    name: 'topNav'
  }
</script>
<style lang="scss" scoped>
$nav-height: 60px;
$nav-bg-color: #324157;
$nav-text-color: #fff;

.nav {
  width: 100%;
  height: $nav-height;
  background: $nav-bg-color;
  /*padding: 13px 20px;*/
  box-sizing: border-box;
  color: $nav-text-color;
  z-index: 99;
  position: fixed;
  left: 0;
  top: 0;

  .el-menu {
    /*background-color: transparent;
    color: $nav-text-color;

    .el-submenu__title {
      color: $nav-text-color;
    }*/
    &.right {
      float: right;
    }
  }

  .logo {
    display: inline-block;
    vertical-align: middle;
    height: $nav-height * 0.7;
    padding: 13px 20px;
  }
  .el-dropdown {
    color: $nav-text-color;
    cursor: pointer;
  }
}
</style>
