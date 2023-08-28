# insurance-service

The `insurance-service` API comprises five distinct endpoints:

1. **Endpoint 1:** This endpoint employs the HTTP POST method to import insurance data in the form of a JSON file:

   ```sh
   curl --location --request POST 'http://localhost:9000/insurance-service/api/insurance/import'
   ```

2. **Endpoint 2:** To import insurance data in JSON format, this endpoint is also invoked using the HTTP POST method. Here's an example cURL command to use this endpoint:

   ```sh
   curl --location --request POST 'http://localhost:9000/insurance-service/api/insurance/' \
   --header 'Content-Type: application/json' \
   --data-raw '<JSON_DATA_HERE>'
   ```

3. **Endpoint 3:** This GET endpoint is designed to retrieve insurance details by their unique identifier (ID). To utilize it, execute the following cURL command:

   ```sh
   curl --location --request GET 'http://localhost:9000/insurance-service/api/insurance/insurance?id=<INSURANCE_ID>'
   ```

4. **Endpoint 4:** This GET endpoint is responsible for fetching all available insurance records. You can use the following cURL command to interact with this endpoint:

   ```sh
   curl --location --request GET 'http://localhost:9000/insurance-service/api/insurance/all'
   ```

5. **Endpoint 5:** To retrieve insurances using pagination, this GET endpoint can be accessed with appropriate query parameters. Here's how you can use this endpoint:

   ```sh
   curl --location --request GET 'http://localhost:9000/insurance-service/api/insurance?page=0&size=4'
   ```
