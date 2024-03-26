<template>
  <b-container fluid id="home_page">
    <Header />

    <b-container fluid id="main-content">
      <div id="genre">
        <div id="genre-subtitle">Genres</div>
        <div id="genre-btn-group">
          <SelectableBtn v-for="v in genreList" :key="v.value" @clickbtn="handleGenreClick(v.value)" :text="v.text" />
        </div>
      </div>
      <div id="release-year">
        <div id="year-subtitle">Release Year</div>
        <div id="year-btn-group">
          <SelectableBtn v-for="v in yearList" :key="v.value" @clickbtn="handleYearClick(v)" :text="v + 's'" />
        </div>
      </div>
      <b-row id="filter-bar">
        <b-col id="country-select-col" cols="12" lg="3" md="4" sm="6" xs="12">
          <div id="country-text">Country</div>
          <b-form-select v-model="selectedCountry">
            <b-form-select-option value>Any</b-form-select-option>
            <b-form-select-option v-for="v in countryList" :key="v.value" :value="v.value">{{ v.text }}</b-form-select-option>
          </b-form-select>
        </b-col>

        <b-col id="language-select-col" cols="12" lg="3" md="4" sm="6" xs="12">
          <div id="language-text">Language</div>
          <b-form-select v-model="selectedLanguage">
            <b-form-select-option v-for="v in languageList" :key="v.value" :value="v.value">{{ v.text }}</b-form-select-option>
          </b-form-select>
        </b-col>

        <b-col id="service-select-col" cols="12" lg="3" md="4" sm="6" xs="12">
          <div id="service-text">Service</div>
          <b-form-select v-model="selectedService">
            <b-form-select-option value>Any</b-form-select-option>
            <b-form-select-option v-for="v in serviceList" :key="v.value" :value="v.value">{{ v.text }}</b-form-select-option>
          </b-form-select>
        </b-col>

        <b-col id="cast-input-col" cols="12" lg="3" md="4" sm="6" xs="12">
          <div id="cast-text">Cast</div>
          <b-form-input id="cast-input-bar" v-model="cast" placeholder="cast"></b-form-input>
        </b-col>
      </b-row>
      <div id="get-movie-btn">
        <b-button variant="outline-dark" @click="searchMovies">
          <b-icon icon="search"></b-icon> Find Movies
        </b-button>
      </div>
    </b-container>

    <b-row align-h="center">
      <b-col>
        <b-card-group columns>
          <b-row>
            <b-col v-for="v in moviesList"  :key="v.value" cols="12" lg="2" md="3" sm="6" xs="6">
              <b-card :title="v.originalTitle" :img-src="v.poster_original" img-top id="movie-card" class="mb-2">
                <b-card-text>
                  <!-- {{ v.overview }} -->
                </b-card-text>
                <template v-for="source in playbackSource">
                  <b-button v-if="v[source.key]"  :key="source.key" :href="v[source.key]" variant="primary" target="_black"
                    class="ms-2 mb-2">
                    {{ source.text }}
                  </b-button>
                </template>
              </b-card>
            </b-col>
          </b-row>
        </b-card-group>
      </b-col>
    </b-row>
    <b-pagination v-show="pageShow" v-model="page" :total-rows="total" :per-page="size" align="center" pills
      @change="handleSearch"></b-pagination>
  </b-container>
</template>

<script>
import SelectableBtn from '@/components/SelectableBtn'
import Header from '@/components/Header'
import request from '../utils/request'

export default {

  name: 'Home',
  components: {
    SelectableBtn,
    Header
  },

  data () {
    return {
      page: 1,
      size: 20,
      total: 0,
      moviesList: [],
      selectedGenres: [],
      selectedYears: [],
      selectedCountry: '',
      selectedLanguage: '',
      selectedService: '',
      cast: '',

      genreList: [
        { value: 1, text: 'Biography' },
        { value: 10042, text: 'Music' },
        { value: 10749, text: 'Romance' },
        { value: 10751, text: 'Family' },
        { value: 10752, text: 'War' },
        { value: 10763, text: 'News' },
        { value: 10764, text: 'Reality' },
        { value: 10767, text: 'Talk Show' },
        { value: 12, text: 'Adventure' },
        { value: 14, text: 'Fantasy' },
        { value: 16, text: 'Animation' },
        { value: 18, text: 'Drama' },
        { value: 2, text: 'Film Noir' },
        { value: 27, text: 'Horror' },
        { value: 28, text: 'Action' },
        { value: 3, text: 'Game Show' },
        { value: 35, text: 'Comedy' },
        { value: 36, text: 'History' },
        { value: 37, text: 'Western' },
        { value: 4, text: 'Musical' },
        { value: 5, text: 'Sport' },
        { value: 53, text: 'Thriller' },
        { value: 6, text: 'Short' },
        { value: 7, text: 'Adult' },
        { value: 80, text: 'Crime' },
        { value: 878, text: 'Science Fiction' },
        { value: 9648, text: 'Mystery' },
        { value: 99, text: 'Documentary' }

      ],
      yearList: ['1940', '1950', '1960', '1970', '1980', '1990', '2000', '2010', '2020'],
      countryList: [
        { value: 'AR', text: 'Argentina' },
        { value: 'AU', text: 'Australia' },
        { value: 'AT', text: 'Austria' },
        { value: 'AZ', text: 'Azerbaijan' },
        { value: 'BE', text: 'Belgium' },
        { value: 'BR', text: 'Brazil' },
        { value: 'BG', text: 'Bulgaria' },
        { value: 'CA', text: 'Canada' },
        { value: 'CL', text: 'Chile' },
        { value: 'CO', text: 'Colombia' },
        { value: 'HR', text: 'Croatia' },
        { value: 'CY', text: 'Cyprus' },
        { value: 'CZ', text: 'Czech Republic' },
        { value: 'DK', text: 'Denmark' },
        { value: 'EC', text: 'Ecuador' },
        { value: 'EE', text: 'Estonia' },
        { value: 'FL', text: 'Finland' },
        { value: 'FR', text: 'France' },
        { value: 'DE', text: 'Germany' },
        { value: 'GR', text: 'Greece' },
        { value: 'HK', text: 'China Hong Kong' },
        { value: 'HU', text: 'Hungary' },
        { value: 'IS', text: 'Iceland' },
        { value: 'IN', text: 'India' },
        { value: 'ID', text: 'Indonesia' },
        { value: 'IE', text: 'Ireland' },
        { value: 'IL', text: 'Israel' },
        { value: 'IT', text: 'Italy' },
        { value: 'JP', text: 'Japan' },
        { value: 'LT', text: 'Lithuania' },
        { value: 'MY', text: 'Malaysia' },
        { value: 'MX', text: 'Mexico' },
        { value: 'MD', text: 'Moldova' },
        { value: 'NL', text: 'Netherlands' },
        { value: 'NZ', text: 'New Zealand' },
        { value: 'MK', text: 'North Macedonia' },
        { value: 'NO', text: 'Norway' },
        { value: 'PA', text: 'Panama' },
        { value: 'PE', text: 'Peru' },
        { value: 'PH', text: 'Philippines' },
        { value: 'PL', text: 'Poland' },
        { value: 'PT', text: 'Portugal' },
        { value: 'RO', text: 'Romania' },
        { value: 'RU', text: 'Russia' },
        { value: 'RS', text: 'Serbia' },
        { value: 'SG', text: 'Singapore' },
        { value: 'ZA', text: 'South Africa' },
        { value: 'KR', text: 'South Korea' },
        { value: 'ES', text: 'Spain' },
        { value: 'SE', text: 'Sweden' },
        { value: 'CH', text: 'Switzerland' },
        { value: 'TH', text: 'Thailand' },
        { value: 'TR', text: 'Turkey' },
        { value: 'UA', text: 'Ukraine' },
        { value: 'AE', text: 'United Emirates' },
        { value: 'GB', text: 'United Kingdom' },
        { value: 'US', text: 'United States' },
        { value: 'VN', text: 'Vietnam' }
      ],
      languageList: [
        { value: '', text: 'Any' }, { value: 'ar', text: 'Arabic' }, { value: 'zh', text: 'Chinese' },
        { value: 'cs', text: 'Czech' }, { value: 'da', text: 'Danish' }, { value: 'nl', text: 'Dutch' },
        { value: 'en', text: 'English' }, { value: 'fi', text: 'Finnish' }, { value: 'fr', text: 'French' },
        { value: 'de', text: 'German' }, { value: 'el', text: 'Greek' }, { value: 'he', text: 'Hebrew' },
        { value: 'hi', text: 'Hindi' }, { value: 'hu', text: 'Hungarian' }, { value: 'is', text: 'Icelandic' },
        { value: 'id', text: 'Indonesian' }, { value: 'it', text: 'Italian' }, { value: 'ja', text: 'Japanese' },
        { value: 'ko', text: 'Korean' }, { value: 'no', text: 'Morwegian' }, { value: 'pl', text: 'Polish' },
        { value: 'pt', text: 'Portuguese' }, { value: 'ro', text: 'Romanian' }, { value: 'ru', text: 'Russian' },
        { value: 'es', text: 'Spanish' }, { value: 'sw', text: 'Swahili' }, { value: 'sw', text: 'Swedish' },
        { value: 'th', text: 'Thai' }, { value: 'tr', text: 'Turkish' }, { value: 'vi', text: 'Vietnamese' }
      ],
      serviceList: [
        { value: 'apple', text: 'Apple' },
        { value: 'curiosity', text: 'Curiosity' },
        { value: 'disney', text: 'Disney' },
        { value: 'hbo', text: 'Hbo' },
        { value: 'hulu', text: 'Hulu' },
        { value: 'mubi', text: 'Mubi' },
        { value: 'netflix', text: 'Netflix' },
        { value: 'paramount', text: 'Paramount' },
        { value: 'peacock', text: 'Peacock' },
        { value: 'prime', text: 'Prime' },
        { value: 'showtime', text: 'Showtime' },
        { value: 'starz', text: 'Starz' }
      ],
      playbackSource: [
        { key: 'appleLink', text: 'Apple' },
        { key: 'curiosityLink', text: 'Curiosity' },
        { key: 'disneyLink', text: 'Disney' },
        { key: 'hboLink', text: 'Hbo' },
        { key: 'huluLink', text: 'Hulu' },
        { key: 'mubiLink', text: 'Mubi' },
        { key: 'netflixLink', text: 'Netflix' },
        { key: 'paramountLink', text: 'Paramount' },
        { key: 'peacockLink', text: 'Peacock' },
        { key: 'primeLink', text: 'Prime' },
        { key: 'showtimeLink', text: 'Showtime' },
        { key: 'starzLink', text: 'Starz' }
      ]
    }
  },
  computed: {
    pageShow () {
      return this.moviesList !== undefined
    }
  },
  methods: {
    handleGenreClick (value) {
      console.log(value)
      const index = this.selectedGenres.indexOf(value)
      if (index > -1) {
        this.selectedGenres.splice(index, 1)
      } else {
        this.selectedGenres.push(value)
      }
    },
    handleYearClick (value) {
      console.log(value)
      const index = this.selectedYears.indexOf(value)
      if (index > -1) {
        this.selectedYears.splice(index, 1)
      } else {
        this.selectedYears.push(value)
      }
    },
    searchMovies () {
      request.post('movie/search', {
        genres: this.selectedGenres,
        year: this.selectedYears,
        language: this.selectedLanguage,
        service: this.selectedService,
        country: this.selectedCountry,
        cast: this.cast,
        page: this.page,
        size: this.size
      }).then(res => {
        this.moviesList = res.data.content
        this.total = res.data.totalElements
      })
    },
    handleSearch (page) {
      this.page = page
      this.searchMovies()
    }
  },
  created () {
    this.searchMovies()
  }
}

</script>

<style scoped>
/*------------------Home Page-------------------*/

#search-bar,
#search-button {
  margin-top: 8px;
}

/* main content */
#main-content {
  font-family: 'Georgia', Serif;
  font-size: 22px;
}

/**genre & release year**/
#main-content button {
  font-size: 18px;
}

#genre-btn-group,
#get-movie-btn {
  text-align: center;
}

#genre {
  margin-bottom: 40px;
  text-align: center;
}

#release-year {
  margin-bottom: 20px;
}

#genre button,
#release-year button {
  margin: 8px;
}

/* filter search bar */

#filter-bar select,
#cast-input-bar {
  width: 70%;
  margin-top: 5px;
  margin-bottom: 15px;
  height: 30px;
}

#cast-input-bar {
  margin-left: 15%;
  border-radius: 0%;
  border-color: rgb(95, 95, 95);
}

#get-movie-btn button {
  margin-top: 50px;
  margin-bottom: 50px;
  width: 25%;
  border-radius: 20px;
}

#movie-card {
    font-size: 18px;
  }

/*end main content*/
@media (min-width: 991px) {
  #movie-card {
    font-size: 15px;
  }
}

/********** Small devices only **********/
@media (min-width: 577px) and (max-width: 767px) {

  .navbar-brand h1 {
    font-size: 27px;
  }

  #main-content {
    font-size: 20px;
  }

  #main-content button {
    font-size: 15px;
  }

  #filter-bar select,
  #cast-input-bar {
    font-size: 15px;
    height: 25;
  }

  #get-movie-btn button {
    margin-top: 40px;
    margin-bottom: 50px;
    width: 30%;
  }

  #movie-card {
    font-size: 12px;
  }

}

/********** Extra small devices Only :-) (e.g., iPhone 4) **********/
@media (max-width: 576px) {
  #main-content {
    font-size: 18px;
  }

  #main-content button {
    font-size: 12px;
  }

  #filter-bar select,
  #cast-input-bar {
    width: 60%;
    height: 20px;
    font-size: 12px;
  }

  #cast-input-bar {
    margin-left: 20%;
  }

  #get-movie-btn button {
    margin-top: 30px;
    margin-bottom: 50px;
    width: 40%;
  }

  #movie-card {
    font-size: 10px;
  }
}

/*------------------End Home Page-------------------*/
</style>
