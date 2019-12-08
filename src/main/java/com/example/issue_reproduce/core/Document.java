package com.example.issue_reproduce.core;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    public Document(){}

    public Document(String name) {
        this.name = name;
    }

//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "createdBy")
//	private User createdBy;
//
//	@Column(name = "documentType")
//	private DocumentType documentType;
//
//	@ManyToMany(mappedBy = "documents")
//	private List<User> users;
//
//	@ManyToMany(mappedBy = "documents")
//	private List<Place> places;
//
//	@ManyToMany(mappedBy = "documents")
//	private List<Company> companies;
//
//	@ManyToMany(mappedBy = "documents")
//	private List<Task> tasks;
//
//	@ManyToMany(mappedBy = "documents")
//	private List<Quote> quotes;
//
//	@ManyToMany(mappedBy = "documents")
//	private List<Invoice> invoices;
//
//	@ManyToMany(mappedBy = "documents")
//	private List<Protocol> protocols;
//
//	@Column(name = "description")
//	private String description;
//
//	@Column(name = "name")
//	private String name;
//
//
//	@ManyToMany(mappedBy = "documents")
//	private List<ContractExpense> contractExpenses;
//
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	@Column(name = "notes")
//	private List<Note> notes;
//
//	@ManyToMany()
//	private List<User> followers;
//
//	public Document() {
//		this.users = new ArrayList<>();
//		this.places = new ArrayList<>();
//		this.companies = new ArrayList<>();
//		this.tasks = new ArrayList<>();
//		this.quotes = new ArrayList<>();
//		this.invoices = new ArrayList<>();
//		this.protocols = new ArrayList<>();
//		this.notes = new ArrayList<>();
//		this.contractExpenses = new ArrayList<>();
//		this.followers = new ArrayList<>();
//	}
//
//	public Document(DocumentType documentType, String path, String description, User createdBy, List<User> users,
//                    List<Place> places, List<Company> companies, List<Task> tasks, String name) {
//		this();
//		this.path = path;
//		this.createdBy = createdBy;
//		this.users = users;
//		for (User u : users) {
//			u.getDocuments().add(this);
//		}
//		this.places = places;
//		for (Place p : places) {
//			p.getDocuments().add(this);
//		}
//		this.companies = companies;
//		for (Company company : companies) {
//			company.getDocuments().add(this);
//		}
//		this.tasks = tasks;
//		for (Task t : tasks) {
//			t.getDocuments().add(this);
//		}
//		this.description = description;
//		this.documentType = documentType;
//		this.name = name;
//	}
//
//	public void remove() {
//		this.users.forEach(user -> user.getDocuments().remove(this));
//		this.companies.forEach(company -> company.getDocuments().remove(this));
//		this.places.forEach(place -> place.getDocuments().remove(this));
//		this.tasks.forEach(task -> task.getDocuments().remove(this));
//	}
//
//	public void update(List<Place> newPlaces, List<Company> newCompanies, List<Task> newTasks, List<User> newUsers) {
//
//		// todo optimize
//
//		this.places.forEach(place -> {
//			place.getDocuments().remove(this);
//		});
//		this.places = new ArrayList<>();
//		newPlaces.forEach(place -> place.addDocument(this));
//
//		this.companies.forEach(company -> {
//			company.getDocuments().remove(this);
//			// if (!newCompanies.contains(company)) {
//			// company.removeDocument(this);
//			// } else {
//			// newCompanies.remove(company);
//			// }
//		});
//		this.companies = new ArrayList<>();
//		newCompanies.forEach(company -> company.addDocument(this));
//
//		this.tasks.forEach(task -> {
//			task.getDocuments().remove(this);
//		});
//		this.tasks = new ArrayList<>();
//		newTasks.forEach(task -> task.addDocument(this));
//
//		this.users.forEach(user -> {
//			user.getDocuments().remove(this);
//		});
//		this.users = new ArrayList<>();
//		newUsers.forEach(user -> user.addDocument(this));
//
//		this.followers.removeAll(users);
//		this.followers.addAll(users);
//	}
}
