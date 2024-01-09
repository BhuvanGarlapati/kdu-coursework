package org.example;
public class APIResponseParser {

    public static Book parse(String response) {
        Book book = new Book();
        String end = "<";
        String start = "<title>";
        String title = parse(response, start, end);
        book.setTitle(title);

        start = "<name>";
        String author = parse(response, start, end);
        book.setAuthor(author);

        start = "<original_publication_year type=\"integer\">";
        String publicationYearStr = parse(response, start, end);
        int publicationYear = Integer.parseInt(publicationYearStr);
        book.setPublicationYear(publicationYear);

        start = "<average_rating>";
        String averageRatingStr = parse(response, start, end);
        double averageRating = Double.parseDouble(averageRatingStr);
        book.setAverageRating(averageRating);

        start = "<ratings_count type=\"integer\">";
        String ratingsCountStr = parse(response, start, end).replaceAll(",", "");
        int ratingsCount = Integer.parseInt(ratingsCountStr);
        book.setRatingsCount(ratingsCount);

        start = "<image_url>";
        String imageUrl = parse(response, start, end);
        book.setImageUrl(imageUrl);

        return book;
    }

    private static String parse(String response, String startRule, String endRule) {
        int startInd = response.indexOf(startRule) + startRule.length();
        int endInd = response.indexOf(endRule, startInd);
        return response.substring(startInd, endInd);
    }


    public static void main(String[] args) {
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">2024</original_publication_year>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +
                "<title>Developer</title>" +
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>BHUVAN GARLA</name>" +
                "</author>" +
                "<image_url>" +
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +
                "</best_book>" +
                "</work>";

        Book parsedBook = APIResponseParser.parse(response);

        // Displaying the parsed book details
        System.out.println("Title: " + parsedBook.getTitle());
        System.out.println("Author: " + parsedBook.getAuthor());
        System.out.println("Publication Year: " + parsedBook.getPublicationYear());
        System.out.println("Average Rating: " + parsedBook.getAverageRating());
        System.out.println("Ratings Count: " + parsedBook.getRatingsCount());
        System.out.println("Image URL: " + parsedBook.getImageUrl());
    }
    }



