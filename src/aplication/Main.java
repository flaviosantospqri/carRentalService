package aplication;

import model.Services.BrazilTaxService;
import model.Services.RentalService;
import model.entities.CarRental;
import model.entities.Vehicle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Entre com os dados do aluguel: ");
        System.out.print("Modelo do carro: ");
        String model = sc.nextLine();
        System.out.println("Retirada (dd/MM/yyyy hh:mm)");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(), fmt);
        System.out.println("Devolução (dd/MM/yyyy hh:mm)");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(), fmt);

        Vehicle vehicle = new Vehicle(model);
        CarRental carRental = new CarRental(start, finish, vehicle);

        System.out.println("Entre com o preço por hora");
        double pricePerHour = sc.nextDouble();
        System.out.println("Entre com o preço por dia");
        double pricePerDay = sc.nextDouble();

        RentalService rs = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());

        rs.processInvoice(carRental);

        System.out.println("FATURA: ");
        System.out.println("Pagamento Básico:  " + String.format("%.2f",carRental.getInvoice().getBasicPayment()));
        System.out.println("Imposto: " + String.format("%.2f", carRental.getInvoice().getTax()));
        System.out.println("Pagamento Total: " + String.format("%.2f", carRental.getInvoice().getTotalPayment()));

        sc.close();
    }
}