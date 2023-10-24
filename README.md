<a name="readme-top"></a>
# Movie Streaming Platform in Spring Boot, PostgreSQL and Vue.js #

## Catalog
<p align="left"><a href="#about-project">About The Project</a></p>
<p align="left"><a href="#data-acquisition-and-processing">Data Acquisition and Processing</a></p>
<p align="left"><a href="#database-design">Database Design</a></p>
<p align="left"><a href="#ui-design">UI Design</a></p>
<p align="left"><a href="#usage">Usage</a></p>
<p align="left"><a href="#contributing">Contributing</a></p>
<p align="left"><a href="#contact">Contact</a></p>
<p align="left"><a href="#acknowledgments">Acknowledgments</a></p>
<p align="left"><a href="#appendix">Appendix</a></p>
<br>

<!-- ABOUT THE PROJECT -->
<a name="about-project"></a>
## About The Project
This project produces a movie searching website which integrates data source from 13 streaming services (Netflix, Prime, Disney+ .etc) with totally 39965 movies. It allow users to search movies through flexible searching criteria and easily find the streaming links of certain services they want.

### Background
Originally, the information of movies is distributed on the internet and different platforms focus on different aspects about movies. This causes some inconvenience for people to find and watch certain movies they want. For example, the Netflix focuses on streaming the video and the Rotten Tomatoes is mainly about recording the acceptance of movies. Moreover, there also exists discrepancy between two platforms of the same type: it’s possible that some movies are contained by Netflix but not by Amazon Prime Video. This causes problems for users because they need to switch between many websites to find what they want. As a consequence, a single monolithic platform including a more complete information of movies on the internet will obviate such an inconvenience and it is appealing to users.

Motivated by such a demand, this project produces a movie search website which integrates resources from tens of different major streaming services such as Netflix, Amazon Prime Video and Disney. The project consists of front-end web pages and a back-end server. The purpose is to provide a compact and time-saving platform with rich resources for movies fans to find movies they want. A very similar and famous website is TMDB [https://www.themoviedb.org/](https://www.themoviedb.org/ "TMDB").

### Built With

1. Vue.js
2. Bootstrap.css
3. Spring Boot
4. PostgreSQL
5. RapidAPI.com

The frontend development is based on Vue.js and Bootstrap and the backend development is based on Spring Boot and PostgreSQL. Data sources of movies is fetched from a public API in RapidAPI.com.


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<a name="data-acquisition-and-processing"></a>
## Data Acquisition and Processing

Raw data of movies used in the project is provided by a public API at RapidAPI. This API provides complete meta data of a single movie including the streaming link from only one service, which lays the foundation for subsequent more complex data processing.

An example of a set of movie meta data provided by the API is attached in the appendix.
<p align="right">(<a href="#appendix">see appendix</a>)</p>


<p align="right">(<a href="#readme-top">back to top</a>)</p>

<a name="database-design"></a>
## Database Design
Basically, the most straightforward way is to map each Java class into a single table. However, when a database table contains a large number of fields, it can cause several issues such as decreased query performance, increased complexity, and difficulty in managing the table. To address these problems, it is often necessary to partition or shard the table into smaller tables based on a specific set of logic fields. This strategy can help to improve query performance, reduce storage requirements, and simplify data management. Based on this strategy, the ER diagram is designed as shown below.
![ER Diagram](./images/database_ER_diagram.png)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<a name="ui-design"></a>
## UI Design

#### Login Page
![Login Page](./images/login_page.png)

#### Home Page
![Home Page](./images/home_page.png)

#### Responsive Design
The interface is intended to be in the responsive style and should fit different sizes of screen. The image below is an example of the interface mode on a cell phone<br>
<br>
<p align="center">
  <img src="./images/home_page_phone_view.png" alt="Home Page Phone View">
</p>

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->
<a name="usage"></a>
## Usage

### Use cases:

1. Sign up account
2. Sign in to an existing account
3. Search Movies Based On Specific Criteria
4. Browse movies by page
5. Token Authentication

### Searching Functionality Representation

1. First, click buttons to set searching critiria in terms of genres, years, countries, languages, services and casts.
![Search Movies](./images/search_movies.png)
 
2. Then click on the "Find Movies" button, it will return all movies matching search criteria.
![Result of Searching](./images/result_of_searching.png)

<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- CONTRIBUTING -->
<a name="contributing"></a>
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
<a name="contact"></a>
## Contact

Letian Jiang (Email: letian.jiang123@outlook.com)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->
<a name="acknowledgments"></a>
## Acknowledgments

The following recourses helped me to complete this project.

* [RapidAPI](https://rapidapi.com/movie-of-the-night-movie-of-the-night-default/api/streaming-availability)
* [Vue.js Documentation](https://vuejs.org/guide/introduction.html)
* [JPA Documentation](https://www.objectdb.com/api/java/jpa)
* [JSON Mapper](https://www.jsonschema2pojo.org/)

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<a name="appendix"></a>
## Appendix

1. Example of Data Provided by API

*{<br>
"imdbID":"tt2395427",<br>
"tmdbID":"99861",<br>
"imdbRating":73,<br>
"imdbVoteCount":872847,<br>
"tmdbRating":72,<br>
"backdropPath":"/6YwkGolwdOMNpbTOmLjoehlVWs5.jpg",<br>
"backdropURLs":<br>
{<br>
"1280":"https://image.tmdb.org/t/p/w1280/6YwkGolwdOMNpbTOmLjoehlVWs5.jpg",<br>
"300":"https://image.tmdb.org/t/p/w300/6YwkGolwdOMNpbTOmLjoehlVWs5.jpg",<br>
"780":"https://image.tmdb.org/t/p/w780/6YwkGolwdOMNpbTOmLjoehlVWs5.jpg",<br>
"original":"https://image.tmdb.org/t/p/original/6YwkGolwdOMNpbTOmLjoehlVWs5.jpg"<br>
},<br>
"originalTitle":"Avengers: Age of Ultron",<br>
"genres":[28,12,878],<br>
"countries":["US"],<br>
"year":2015,<br>
"runtime":141,<br>
"cast":["Robert Downey Jr.","Chris Hemsworth","Mark Ruffalo","Chris Evans","Scarlett Johansson","Jeremy Renner","James Spader"],<br>
"significants":["Joss Whedon"],<br>
"title":"Avengers: Age of Ultron",<br>
"overview":"When Tony Stark tries to jumpstart a dormant peacekeeping program, things go awry and Earth’s Mightiest Heroes are put to the ultimate test as the fate of the planet hangs in the balance. As the villainous Ultron emerges, it is up to The Avengers to stop him from enacting his terrible plans, and soon uneasy alliances and unexpected action pave the way for an epic and unique global adventure.",<br>
"tagline":"A New Age Has Come.",<br>
"video":"JAUoeqvedMo",<br>
"posterPath":"/4ssDuvEDkSArWEdyBl2X5EHvYKU.jpg",<br>
"posterURLs":<br>
{<br>
"154":"https://image.tmdb.org/t/p/w154/4ssDuvEDkSArWEdyBl2X5EHvYKU.jpg",<br>
"185":"https://image.tmdb.org/t/p/w185/4ssDuvEDkSArWEdyBl2X5EHvYKU.jpg",<br>
"342":"https://image.tmdb.org/t/p/w342/4ssDuvEDkSArWEdyBl2X5EHvYKU.jpg",<br>
"500":"https://image.tmdb.org/t/p/w500/4ssDuvEDkSArWEdyBl2X5EHvYKU.jpg",<br>
"780":"https://image.tmdb.org/t/p/w780/4ssDuvEDkSArWEdyBl2X5EHvYKU.jpg",<br>
"92":"https://image.tmdb.org/t/p/w92/4ssDuvEDkSArWEdyBl2X5EHvYKU.jpg",<br>
"original":"https://image.tmdb.org/t/p/original/4ssDuvEDkSArWEdyBl2X5EHvYKU.jpg"<br>
},<br>
"age":11,<br>
"streamingInfo":<br>
{<br>
"disney":<br>
{<br>
"us":<br>
{<br>
"link":"https://www.disneyplus.com/movies/-/76IUxY0rNHzt",<br>
"added":1606700591,<br>
"leaving":0<br>
}<br>
}<br>
},<br>
"originalLanguage":"en"<br>
}<br>*

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
