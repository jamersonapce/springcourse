package com.apce;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.apce.domains.Address;
import com.apce.domains.Category;
import com.apce.domains.City;
import com.apce.domains.Customer;
import com.apce.domains.Order;
import com.apce.domains.OrderItem;
import com.apce.domains.Payment;
import com.apce.domains.PaymentCard;
import com.apce.domains.PaymentSlip;
import com.apce.domains.Phone;
import com.apce.domains.Product;
import com.apce.domains.State;
import com.apce.domains.enums.CustomerType;
import com.apce.domains.enums.PaymentStatus;
import com.apce.repositories.AddressRepository;
import com.apce.repositories.CategoryRepository;
import com.apce.repositories.CityRepository;
import com.apce.repositories.CustomerRepository;
import com.apce.repositories.OrderItemRepository;
import com.apce.repositories.OrderRepository;
import com.apce.repositories.PaymentRepository;
import com.apce.repositories.ProductRepository;
import com.apce.repositories.StateRepository;
import com.apce.repositories.PhoneRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoriaRepository;
	@Autowired
	private ProductRepository produtoRepository;
	@Autowired
	private StateRepository estadoRepository;
	@Autowired
	private CityRepository cidadeRepository;
	@Autowired
	private CustomerRepository clienteRepository;
	@Autowired
	private AddressRepository enderecoRepository;
	@Autowired
	private OrderRepository pedidoRepository;
	@Autowired
	private PaymentRepository pagamentoRepository;
	@Autowired
	private OrderItemRepository itemOrderRepository;
	@Autowired
	private PhoneRepository phoneRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = Category.builder().id(null).name("Informática").build();
		Category cat2 = Category.builder().id(null).name("Escritório").build();

		Product p1 = Product.builder().id(null).name("Computador").value(new BigDecimal("2000")).build();
		Product p2 = Product.builder().id(null).name("Impressora").value(new BigDecimal("800.00")).build();
		Product p3 = Product.builder().id(null).name("Mouse").value(new BigDecimal("80.00")).build();

		cat1 = cat1.toBuilder().products(Arrays.asList(p1, p2, p3)).build();
		cat2 = cat2.toBuilder().products(Arrays.asList(p2)).build();

		p1 = p1.toBuilder().categories(Arrays.asList(cat1)).build();
		p2 = p2.toBuilder().categories(Arrays.asList(cat1, cat2)).build();
		p3 = p3.toBuilder().categories(Arrays.asList(cat1)).build();

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		State est1 = State.builder().id(null).name("Minas Gerais").build();
		State est2 = State.builder().id(null).name("São Paulo").build();

		estadoRepository.saveAll(Arrays.asList(est1, est2));

		City c1 = City.builder().id(null).name("Uberlândia").state(est1).build();
		City c2 = City.builder().id(null).name("São Paulo").state(est2).build();
		City c3 = City.builder().id(null).name("Campinas").state(est2).build();

//		est1 = est1.toBuilder().cities(Arrays.asList(c1)).build();
//		est2 = est2.toBuilder().cities(Arrays.asList(c2, c3)).build();

		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Customer cli1 = Customer.builder().id(null).name("Maria Silva").email("maria@gmail.com")
				.cpfOrCnpj("36378912377").customerType(CustomerType.PHYSICALPERSON.getDescription()).build();

		Phone f1 = Phone.builder().id(null).number("27363323").build();
		Phone f2 = Phone.builder().id(null).number("93838393").build();

		f1 = phoneRepository.saveAndFlush(f1);
		f2 = phoneRepository.saveAndFlush(f2);

		Address e1 = Address.builder().id(null).streetAddress("Rua Flores Apto 303").number("300")
				.neighborhood("Jardim").zipCode("38220834").city(c1).build();
		Address e2 = Address.builder().id(null).streetAddress("Avenida Matos Sala 800").number("105")
				.neighborhood("Centro").zipCode("38777012").city(c2).build();

		e1 = enderecoRepository.saveAndFlush(e1);
		e2 = enderecoRepository.saveAndFlush(e2);

		cli1 = cli1.toBuilder().phones(Arrays.asList(f1, f2)).build();
		cli1 = cli1.toBuilder().addresses(Arrays.asList(e1, e2)).build();

		cli1 = clienteRepository.saveAndFlush(cli1);

		f1 = f1.toBuilder().customer(cli1).build();
		f2 = f2.toBuilder().customer(cli1).build();
		e1 = e1.toBuilder().customer(cli1).build();
		e2 = e2.toBuilder().customer(cli1).build();
		
		phoneRepository.saveAll(Arrays.asList(f1,f2));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		Order ped1 = Order.builder().id(null)
				.instante(LocalDateTime.parse("30/09/2017 10:32", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
				.customer(cli1).deliveryAddress(e1).build();
		Order ped2 = Order.builder().id(null)
				.instante(LocalDateTime.parse("10/10/2017 19:35", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")))
				.customer(cli1).deliveryAddress(e2).build();

		Payment pagto1 = PaymentCard.builder().id(null).status(PaymentStatus.SETTLED.getDescription()).order(ped1)
				.installment(6).build();

		ped1 = ped1.toBuilder().payment(pagto1).build();

		Payment pagto2 = PaymentSlip.builder().id(null).status(PaymentStatus.PENDENT.getDescription()).order(ped2)
				.dueDate(LocalDate.parse("20/10/2017", DateTimeFormatter.ofPattern("dd/MM/yyyy"))).build();
		ped2 = ped2.toBuilder().payment(pagto2).build();

		cli1 = cli1.toBuilder().orders(Arrays.asList(ped1, ped2)).build();

		ped1 = pedidoRepository.saveAndFlush(ped1);
		ped2 = pedidoRepository.saveAndFlush(ped2);
		
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		OrderItem ip1 = new OrderItem(ped1, p1, new BigDecimal("0.00"), new BigDecimal("2000.00"), 1);
		OrderItem ip2 = new OrderItem(ped1, p3, new BigDecimal("0.00"), new BigDecimal("80.00"), 2);
		OrderItem ip3 = new OrderItem(ped2, p2, new BigDecimal("100.00"), new BigDecimal("800.00"), 1);

		ped1 = ped1.toBuilder().items(Arrays.asList(ip1, ip2)).build();
		ped2 = ped1.toBuilder().items(Arrays.asList(ip3)).build();

		p1 = p1.toBuilder().items(Arrays.asList(ip1)).build();
		p2 = p2.toBuilder().items(Arrays.asList(ip3)).build();
		p3 = p3.toBuilder().items(Arrays.asList(ip2)).build();

		itemOrderRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
	}

}
