<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <ul>
      <li><a href="javascript:void(0)" v-on:click="logoff">Logoff</a></li>
    </ul>
  </div>
</template>

<script>
import router from '../routes'

export default {
  name: 'hello',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
    logoff () {
      window.sessionStorage.setItem('isAuthenticated', 'false')
      router.replace('/login')
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
