<template>
  <b-container fluid id="sign_in_page">

    <Header />

    <b-container fluid id="signin-main-content">
      <div id="whole-login-block">
        <div class="vertical-divider d-none d-md-block"></div>
        <b-row>
          <b-col cols="12" md="6" xs="12">
            <div id="sign-up-block">
              <div id="google-btn">
                <b-button variant="outline-dark">
                  <b-img id="google-icon" src="~@/assets/image/google-icon-2.png"></b-img> Sign In with
                  Google
                </b-button>
              </div>
              <div id="email-btn">
                <b-button variant="outline-dark">
                  <b-icon-envelope id="email-icon"></b-icon-envelope> Sign Up with Email
                </b-button>
              </div>
            </div>
          </b-col>

          <b-col cols="12" md="6" xs="12">
            <div id="account-input-block">
              <b-form @submit="login">
                <div id="email-input">
                  <b-form-input type="email" v-model="loginFormData.email" placeholder="Email"></b-form-input>
                </div>
                <div id="password-input">
                  <b-form-input type="password" v-model="loginFormData.password" placeholder="Password"></b-form-input>
                </div>
                <div id="signin-btn">
                  <b-button variant="secondary" type="submit">Sign In</b-button>
                </div>
              </b-form>
              <div id="forgot-password">
                <b-link href="resetPassword.html">Forgot Password?</b-link>
              </div>
            </div>
          </b-col>
        </b-row>
      </div>
    </b-container>
  </b-container>
</template>

<script>
import request from '../utils/request'
import Header from '@/components/Header'

export default {
  components: {
    Header
  },
  data: () => {
    return {
      loginFormData: {
        email: '',
        password: ''
      }
    }
  },
  methods: {
    login () {
      if (this.loginFormData.email.trim() === '' && this.loginFormData.password.trim() === '') {
        return false
      }

      request.post('/user/login', this.loginFormData).then(res => {
        if (res.data.code === 200) {
          localStorage.setItem('token', res.data.token)
          localStorage.setItem('user', JSON.stringify(res.data.data))
          this.$router.push('/')
        }
      })

      return false
    }
  }
}
</script>

<style scoped>
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

/**end header**/

#signin-main-content {
  margin-top: 200px;
  font-family: 'Georgia', Serif;
  font-size: 20px;
}

#whole-login-block button,
#whole-login-block input {
  width: 60%;
  height: 40px;
  font-size: 20px;
}

#account-input-block input {
  margin-left: 20%;
}

#email-btn,
#password-input,
#signin-btn {
  margin-top: 20px;
  color: aliceblue;
}

#google-icon {
  width: 25px;
  height: 25px;
  margin-right: 10px;
  margin-bottom: 5px;
}

#email-icon {
  margin-right: 10px;
}

.glyphicon-envelope {
  width: 25px;
  height: 25px;
  margin-right: 30px;
  margin-top: 3px;
}

#forgot-password {
  margin-top: 10px;
  text-align: center;
}

.vertical-divider {
  border-left: 2px solid gray;
  height: 200px;
  position: absolute;
  left: 50%;
  margin-left: -3px;
}

/********** large and medium devices **********/
@media (min-width: 768px) {
  #nav-search-btn {
    margin-left: 10px;
  }
}

/********** medium devices only **********/
@media (min-width: 768px) and (max-width: 991px) {

  .navbar-brand h1 {
    font-size: 27px;
  }

  #whole-login-block button,
  #whole-login-block input {
    width: 80%;
    height: 40px;
  }

  #account-input-block input {
    margin-left: 10%;
  }
}

/********** small devices only **********/
@media (min-width: 577px) and (max-width: 767px) {

  .navbar-brand h1 {
    font-size: 27px;
  }

  #whole-login-block button,
  #whole-login-block input {
    width: 80%;
    height: 40px;
    font-size: 16px;
  }

  #account-input-block input {
    margin-left: 10%;
  }

  #email-input {
    margin-top: 50px;
  }
}

/********** extra small devices Only :-) (e.g., iPhone 4) **********/
@media (max-width: 576px) {
  .navbar-brand h1 {
    font-size: 22px;
  }

  #signin-main-content {
    margin-top: 100px;
  }

  #whole-login-block button,
  #whole-login-block input {
    width: 100%;
    margin-left: 0;
    height: 40px;
    font-size: 15px;
  }

  #email-input {
    margin-top: 50px;
  }

  #forgot-password {
    font-size: 15px;
  }
}
</style>
