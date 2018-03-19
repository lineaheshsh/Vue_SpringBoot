<template>
  <div id="app">
    <img src="./assets/logo.png">
    <div id="menuBar">
      <router-link to="/Info">Info</router-link>
    </div>
      <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

#menuBar {
    width: 500px;
    text-align: center;
    margin: 0 auto;
}
</style>
