package rent;

import java.time.LocalDate;

public class RentModel {
    private int id;
    private LocalDate rentDate;
    private LocalDate returnDate;
    private int movieId;
    private String renter;

    public RentModel(int id, LocalDate rentDate, LocalDate returnDate, int movieId, String renter) {
        this.id = id;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.movieId = movieId;
        this.renter = renter;
    }

    public int getId() {
        return id;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getRenter() {
        return renter;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setRenter(String renter) {
        this.renter = renter;
    }
}
