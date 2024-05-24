Short_Team3

<h1 align="center">Team3: Pardys BE Repository</h1>

## Philosophy
We believe using technology should be fun and light, not stern and stressful. It's cool to be user-friendly; using complicated jargon without explanations doesn't make for better results – if anything, it scares people off. We don't want to be intimidating, we want to be inviting and enjoyable, and then casually be the best choice around. Real casually.

We offer a simple API that allows users to perform CRUD operations, letting their inner voices be heard, post pictures, and view them. Our goal is to make the web a place where sharing and connecting is seamless and delightful.

We believe frameworks should be disposable and components recyclable. We don't want a web where walled gardens jealously compete with one another. By making interoperability the norm, switching from one framework to another becomes frictionless. Our design is modest; we don't expect it to be top of the class forever, so we've made it as easy to discard as it is to adopt.

We don't believe that bigger is better. Big APIs, large complexities, and long files – we see them as omens of impending user complexity. We want everyone on a team, no matter the size, to fully understand how an application is laid out. And once an application is built, we want it to be small, performant, and easy to understand. All of which makes for easy-to-debug code, better results, and super smiley faces.



## API

| Method   | URL                                      | Description                              |
| -------- | ---------------------------------------- | ---------------------------------------- |
| `GET`    | `/post`                             | Retrieve all posts.                      |
| `POST`   | `/post`                             | Create a new post.                       |
| `GET`    | `/post/{id}`                          | Retrieve post #id.                       |
| `DELETE`  | `/posts/{id}`                          | Delete post #id.                 |
| `PATCH`   | `/post/{id}`                 | update post #id.                 |
| `GET`    | `/post/category/{category}` | Retrieve all posts in category. |
| `POST` | `/image` | Upload an image                    |
| `GET`    | `/image/{id}` | Retrieve image #id |
| `GET`    | `/image/info/{id}` | Retrieve info(filename, filetype) about image #id |

## Swagger
![](https://media1.giphy.com/media/v1.Y2lkPTc5MGI3NjExc3k1ZWxtZDJiOGlleTdidnpobDQ1NDRmY3N5endnaGF4eXMzNzRybSZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9dg/wp0qAbtr5M6Z1wfHAZ/giphy.gif)

<br/>
#### Link-to-Swagger: http://[ip-address]:8080/swagger-ui/index.html#/




## HTTP Response Status Codes
<br/>
One of the most important things in an API is how it returns response codes. Each response code means a different thing and consumers of your API rely heavily on these codes.
<br/>

| Code  | Title                     | Description                              |
| ----- | ------------------------- | ---------------------------------------- |
| `200` | `OK`                      | When a request was successfully processed (e.g. when using `GET`, `PATCH`, `PUT` or `DELETE`). |
| `201` | `Created`                 | Every time a record has been added to the database (e.g. when creating a new user or post). |
| `304` | `Not modified`            | When returning a cached response. |
| `400` | `Bad request`             | When the request could not be understood (e.g. invalid syntax). |
| `401` | `Unauthorized`            | When authentication failed. |
| `403` | `Forbidden`               | When an authenticated user is trying to perform an action, which he/she does not have permission to. |
| `404` | `Not found`               | When URL or entity is not found. |
| `440` | `No accept header`        | When the required "Accept" header is missing from the request. |
| `422` | `Unprocessable entity`    | Whenever there is something wrong with the request (e.g. missing parameters, validation errors) even though the syntax is correct (ie. `400` is not warranted). |
| `500` | `Internal server error`   | When an internal error has happened (e.g. when trying to add/update records in the database fails). |
| `502` | `Bad Gateway`             | When a necessary third party service is down. |

