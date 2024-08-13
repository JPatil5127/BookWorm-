package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class PublisherMaster {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int publisherId;
	    
	    private String publisherName;
	    // Getters and Setters
		public int getPublisherId() {
			return publisherId;
		}

		public void setPublisherId(int publisherId) {
			this.publisherId = publisherId;
		}

		public String getPublisherName() {
			return publisherName;
		}

		public void setPublisherName(String publisherName) {
			this.publisherName = publisherName;
		}


		
	    
}
