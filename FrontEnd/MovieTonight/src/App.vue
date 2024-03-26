<template>
  <div id="app">
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
  margin-top: 0px;
}
/*------------------Global-------------------*/
/**header**/
.navbar-brand h1 {
    /* title name */
    font-family: 'Oxygen', sans-serif;
    color: #000000;
    font-size: 30px;
    text-transform: uppercase;
    font-weight: bold;
    text-shadow: 1px 1px 1px #222;
    margin-top: 0;
    margin-bottom: 0;
    line-height: .75;
}

.navbar-nav {
    font-family: 'Georgia', Serif;
}

#nav-search-bar,
#nav-search-btn {
    margin-top: 10px;
}

#nav-search-btn {
    background-color: rgb(211, 209, 209);
}

/********** Large and medium devices **********/
@media (min-width: 768px) {
    #nav-search-btn {
        margin-left: 10px;
    }
}

/********** Medium devices only **********/
@media (min-width: 768px) and (max-width: 991px) {

    .navbar-brand h1 {
        font-size: 27px;
    }

}

@media (max-width: 576px) {
    .navbar-brand h1 {
        font-size: 22px;
    }
}

/********** Small and extra small devices **********/
/* @media (max-width: 768px) {

} */

/**end header**/
/*------------------End Global-------------------*/
</style>
