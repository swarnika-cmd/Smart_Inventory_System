# Product Requirements Document (PRD)

## Product Name

Smart Inventory Management System (SIMS)

---

## 1. Problem Statement

Inventory management in small to mid-scale environments (retail stores, hostels/mess kitchens, warehouses, labs) is largely manual. Stock counting is:

* Time-consuming
* Error-prone
* Dependent on human diligence

There is no simple system that allows users to **scan inventory using images and automatically update stock counts**, while also providing a **robust backend for tracking, auditing, and analytics**.

---

## 2. Product Vision

Build a **backend-driven inventory management platform** that supports traditional inventory operations and augments them with a **computer vision–based auto-counting feature**.

The system should:

* Work without ML initially
* Gradually integrate ML as an optional enhancement
* Be scalable, modular, and production-oriented

---

## 3. Target Users

### Primary Users

* Store managers
* Hostel/mess administrators
* Warehouse supervisors

### Secondary Users

* Inventory staff
* Auditors
* Developers integrating inventory services

---

## 4. Goals & Success Metrics

### Goals

* Reduce manual inventory counting effort
* Improve stock accuracy
* Provide clear inventory visibility
* Enable ML-based automation without disrupting core workflows

### Success Metrics

* Inventory update latency < 2 seconds
* Stock accuracy improvement after ML integration
* Ability to process image-based inventory updates
* System stability even when ML service is unavailable

---

## 5. In-Scope Features

### Phase 1: Core Inventory Backend (Non-ML)

* Inventory item CRUD operations
* Category management
* Stock quantity tracking
* Low-stock threshold alerts
* Inventory audit logs

### Phase 2: Role & Access Management

* Admin vs Staff roles
* Restricted access to critical operations
* Inventory change tracking per user

### Phase 3: Computer Vision–Based Counting (ML Feature)

* Image upload for inventory scanning
* Object detection to identify inventory items
* Automatic counting per item type
* Backend validation and update

### Phase 4: Analytics & Insights

* Inventory usage trends
* Low-stock prediction
* ML accuracy monitoring

---

## 6. Out of Scope (Initial Versions)

* Real payment processing
* Hardware-level camera integration
* Real-time video stream processing
* Supplier-side integrations

---

## 7. User Stories

### Inventory Manager

* As a manager, I want to add and update inventory items so that stock is tracked centrally.
* As a manager, I want alerts when items fall below a threshold.

### Inventory Staff

* As a staff member, I want to upload an image of inventory and automatically update counts.

### System

* As a system, I should allow manual overrides if ML-based counting fails.

---

## 8. Functional Requirements

### Inventory Management

* Create, update, delete inventory items
* Adjust quantities manually
* View inventory by category

### Image-Based Inventory Update

* Accept image uploads
* Send image to ML inference service
* Receive item-count mapping
* Update inventory accordingly

### Reliability

* ML service failures must not crash backend
* Manual fallback must always be available

---

## 9. Non-Functional Requirements

* Scalable REST APIs
* Clear separation between backend and ML services
* Fault tolerance for ML integration
* Clean logging and auditability

---

## 10. Technical Architecture (High-Level)

### Backend

* Spring Boot (REST APIs)
* PostgreSQL (primary DB)
* Redis (optional caching)

### ML Service

* Python-based inference service
* YOLO-based object detection model
* FastAPI interface

### Communication

* REST-based service-to-service calls

---

## 11. Data Model (High-Level)

### InventoryItem

* id
* name
* category
* quantity
* threshold
* lastUpdated

### InventoryAuditLog

* id
* itemId
* oldQuantity
* newQuantity
* updatedBy
* timestamp

---

## 12. Risks & Mitigations

| Risk                      | Mitigation                             |
| ------------------------- | -------------------------------------- |
| ML model inaccuracies     | Manual override + confidence threshold |
| Dataset bias              | Controlled dataset creation            |
| Backend-ML tight coupling | Separate ML microservice               |

---

## 13. Milestones

* Phase 1: Core backend ready
* Phase 2: Role-based access
* Phase 3: ML integration
* Phase 4: Analytics & polish

---

## 14. Open Questions

* Which inventory domain to prioritize first?
* Cloud vs local deployment?
* Real-time vs batch image processing?

---

## 15. Summary

This project aims to demonstrate:

* Strong backend engineering skills
* Practical ML system integration
* Clean system design and LLD
* Real-world problem solving

It is designed to be built incrementally, with each phase independently valuable and resume-worthy.
