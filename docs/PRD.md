# Product Requirements Document (PRD)

## Product Name

Smart Retail Inventory Management System (SRIMS)

---

## 1. Problem Statement

In retail stores, inventory counting is still largely manual. Store employees physically check shelves and backrooms to estimate stock levels. This process is:

* Time-consuming
* Error-prone
* Inconsistent across shifts
* Not scalable as store size or SKU count increases

As a result, retailers face:

* Frequent stock-outs
* Over-ordering and wastage
* Poor visibility into real-time inventory

---

## 2. Product Vision

Build a **backend-driven smart retail inventory platform** that automates inventory tracking and enhances it with **computer vision–based shelf scanning**.

The system should:

* Work reliably without ML as a baseline
* Use ML only as an assistive feature, not a dependency
* Be modular, scalable, and production-oriented
* Reflect real-world retail workflows

---

## 3. Target Users

### Primary Users

* Retail store managers
* Inventory supervisors

### Secondary Users

* Store staff
* Auditors
* Operations analysts

---

## 4. Goals & Success Metrics

### Product Goals

* Reduce manual stock counting effort
* Improve inventory accuracy
* Provide near real-time inventory visibility
* Enable automated stock updates from shelf images

### Success Metrics

* Inventory update latency < 2 seconds
* Reduction in manual counting operations
* Accurate detection and counting from shelf images
* Backend remains fully functional even if ML service fails

---

## 5. In-Scope Features

### Phase 1: Core Inventory Backend (Non-ML)

* Inventory item CRUD operations
* Category-based organization
* Stock quantity tracking
* Low-stock threshold alerts
* Inventory audit logs

### Phase 2: Access & Control

* Admin vs Staff roles
* Controlled inventory modification rights
* Change tracking per user

### Phase 3: Computer Vision–Based Inventory Counting

* Shelf image upload
* Object detection of retail items
* Item-wise count extraction
* Confidence-based validation
* Manual override for incorrect detections

### Phase 4: Inventory Analytics

* Stock trend analysis
* Low-stock prediction signals
* ML accuracy monitoring

---

## 6. Out of Scope (Initial Versions)

* Payment processing
* Supplier procurement automation
* Real-time video stream processing
* Hardware camera integrations
* Multi-store chain synchronization

---

## 7. User Stories

### Store Manager

* As a store manager, I want to see current stock levels so I can plan reordering.
* As a store manager, I want alerts when items fall below a threshold.

### Store Staff

* As a staff member, I want to upload shelf images to update inventory faster.

### System

* As a system, I must allow manual inventory updates if ML-based counting is unavailable or inaccurate.

---

## 8. Functional Requirements

### Inventory Management

* Create, update, and delete inventory items
* Update quantities manually
* View inventory by category and stock level

### Image-Based Inventory Update

* Accept image uploads
* Forward images to ML inference service
* Receive item-to-count mapping
* Validate confidence scores
* Update inventory accordingly

### Reliability & Fallback

* ML failures must not impact core inventory APIs
* Manual updates must always be available

---

## 9. Non-Functional Requirements

* RESTful API design
* Scalable backend architecture
* Clear separation between backend and ML services
* Fault tolerance and graceful degradation
* Structured logging and auditability

---

## 10. High-Level Technical Architecture

### Backend Service

* Java 17
* Spring Boot
* REST APIs
* PostgreSQL (primary database)

### ML Inference Service

* Python-based service
* YOLO-based object detection model
* REST interface

### Communication

* Backend ↔ ML via REST APIs

---

## 11. Data Model (High-Level)

### Invent
