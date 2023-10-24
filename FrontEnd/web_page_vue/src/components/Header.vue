<template>
  <header>
    <b-navbar toggleable="md" type="light" variant="light">
      <b-navbar-brand>
        <router-link style="text-decoration: none; color: inherit;" to="/">
          <h1>Movie Tonight</h1>
        </router-link>
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav class="justify-content-end">
        <!-- <b-navbar-nav class="ml-auto"></b-navbar-nav> -->
        <b-navbar-nav id="navbar-nav" class="ml-auto">
          <b-nav-form>
            <b-form-input id="nav-search-bar" type="search" placeholder="Search"></b-form-input>
          </b-nav-form>
          <b-nav-form>
            <b-button id="nav-search-btn" variant="light">Search</b-button>
          </b-nav-form>
          <b-nav-item>
            <b-nav-item active class="d-block d-md-none">
              <router-link style="text-decoration: none; color: inherit;" to="/Home"> Home</router-link>
            </b-nav-item>
          </b-nav-item>
          <b-nav-item>
            <b-nav-item href="watchlist.html" variant="outline-success">WatchList</b-nav-item>
          </b-nav-item>
          <b-nav-item v-if="!isAuth">
            <b-nav-item variant="outline-success">
              <router-link style="text-decoration: none; color: inherit;" to="/sign_in"> Sign
                In</router-link>
            </b-nav-item>
          </b-nav-item>
          <template v-else>
            <b-nav-item>
              <b-nav-item variant="outline-success">
                {{ user.userName }}
              </b-nav-item>
            </b-nav-item>
            <b-nav-item>
              <b-nav-item variant="outline-success" @click="logout">
                Logout
              </b-nav-item>
            </b-nav-item>
          </template>

        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </header>
</template>

<script>
export default {
  data: () => {
    return {
      user: JSON.parse(localStorage.getItem('user'))
    }
  },
  computed: {
    isAuth: () => {
      return localStorage.getItem('token') !== null && localStorage.getItem('user') !== null
    }
  },
  methods: {
    logout () {
      localStorage.removeItem('token')
      localStorage.removeItem('user')
      this.$router.push('/sign_in')
    }
  }
}
</script>
