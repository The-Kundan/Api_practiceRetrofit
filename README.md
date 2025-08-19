# Retrofit API Call Demo (Android)

This project demonstrates how to make API calls using **Retrofit** in Android. It includes examples of `GET`, `POST`, `PUT`, `PATCH`, and `DELETE` requests with both `@Body`, `@Field`, `@Path`, and `@Query` usage.

## Features
- Fetch posts and comments from an API
- Send data using `POST` with both `@Body` and `@FormUrlEncoded`
- Update data using `PUT` and `PATCH`
- Delete a resource using `DELETE`
- Demonstrates handling responses with Retrofit

## API Reference
Using [JSONPlaceholder](https://jsonplaceholder.typicode.com/) as the test API.

### Endpoints Used
- `GET /posts` → Fetch all posts  
- `GET /posts/1/comments` → Fetch comments without dynamic ID  
- `GET /posts/{id}/comments` → Fetch comments with dynamic ID  
- `GET /comments?id=1` → Fetch comment using query  
- `POST /posts` → Create a new post (with `@Body` or `@FormUrlEncoded`)  
- `PUT /posts/{id}` → Replace a post  
- `PATCH /posts/{id}` → Update part of a post  
- `DELETE /posts/{id}` → Delete a post  

## Tech Stack
- **Java (Android)**
- **Retrofit**
- **Gson Converter**
- **RecyclerView** (for displaying data)

## How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/your-repo-name.git](https://github.com/The-Kundan/Api_practiceRetrofit.git
2. Open in Android Studio.
3. Sync Gradle.
4. Run the app on an emulator or device with internet access.

## Output
- Lists of posts and comments retrieved from the API.
- Console logs for created, updated, and deleted posts.

## Reference
- Retrofit Documentation
- JSONPlaceholder API   
