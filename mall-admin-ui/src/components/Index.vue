<template>
  <div class="hello">
    <TopNav>
      <!--<span slot="appName">Mall Admin</span>-->
    </TopNav>

    <div class="console-sidebar">
      <el-menu default-active="/category" @open="handleOpen" @close="handleClose" router unique-opened>
        <template v-for="(route, index) in menu">
          <template v-if="route.children && route.name">
            <el-submenu :index="route.path">
              <template slot="title"><i class="el-icon-message"></i>{{route.name}}</template>
              <el-menu-item :index="cRoute.path" v-for="cRoute in route.children">{{cRoute.name}}</el-menu-item>
            </el-submenu>
          </template>
          <template v-if="!route.children && route.name">
            <el-menu-item :index="route.path"><i class="el-icon-message"></i>{{route.name}}</el-menu-item>
          </template>
        </template>
      </el-menu>
    </div>

    <div class="console-content">
      <router-view></router-view>
    </div>
  </div>
</template>

<script type="text/babel">
  import router from '../routes'
  import TopNav from './TopNav'
  import * as types from '../store/mutation-types'

  export default {
    components: { TopNav },
    name: 'hello',
    data () {
      return {
        msg: 'Welcome to Your Vue.js App',
        activeIndex: '1',
        activeIndex2: '1',
        isRouterMenu: true,
        menu: [
          {
            path: '/',
            name: 'Dashboard'
          },
          {
            path: '/category',
            name: '类目管理',
            children: [
              {
                path: '/category',
                name: '后台类目'
              }
            ]
          },
          {
            path: '/goods',
            name: '商品管理',
            children: [
              {
                path: '/create-goods',
                name: '发布商品'
              }
            ]
          }
        ]
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
        this.$store.state.commit(types.LOGOUT)
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
  .console-content {
    position: relative;
    top: 60px;
    margin-left: 230px;
    padding: 20px 10px;
  }
  a {
    color: #42b983;
  }
  .grid-content {
    border-radius: 4px;
    min-height: 36px;
  }
</style>
