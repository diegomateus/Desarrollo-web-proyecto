<template>
  <div id="navigation-bar">
    <nav>
      <ul>
        <li><a href="#" id="logo">LOGO/Nombre</a></li>
        <li><a href=#>Serach</a></li>
        <li><a href=#>About</a></li>
        <li><a href=#>Portfolio</a></li>
        <li><a href=#>Services</a></li>
        <li><a href=#>Contact</a></li>
      </ul>
    </nav>
    <br>
  </div>
  
</template>

<script lang="ts">
export default({
  name: "Template",
});
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
@import url("https://fonts.googleapis.com/css?family=Fira+Sans");

#container {
  width: 100%;
  display: inline-block;
}

/** HEADER */

/** NAVIGATION BAR */
nav {
  overflow: hidden;
  background-color: #333;
  position: fixed;
  top: 0;
  right: 0;
  width: 100%;
  ul {
    text-align: center;
    list-style-type: none;
    list-style-type: none;
    margin: 0;
    padding: 15px;
    li {
      display: inline;
      font-family: "Fira Sans", sans-serif;
      font-size: 17px;
      a {
        color: #f2f2f2;
        text-decoration: none;
        padding: 14px;
        &:hover {
          background-color: #111;
        }
      }
    }
  }
}

.content {
  text-align: center;
}
</style>