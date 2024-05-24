# Short_Team3

Team3: Pardys BE Repository
<br/>
API
<br/>

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
