# Yven Quantums Optics - Kafka Notification Module

## Overview
This module handles notification management and processing using Apache Kafka for event-driven communication.

## Architecture
- **Ports**:
  - `ForNotificationConsumer`: Interface for consuming notifications
  - `ForNotification`: Interface for processing notifications
  - `ForManagingNotification`: Interface for managing notification storage
  - `ForManagingNotificationSender`: Interface for sending notifications

- **Adapters**:
  - `NotificationAdapter`: Web controller for notification management
  - `NotificationConsumerAdapter`: Kafka consumer for receiving notifications
  - `KafkaNotificationProxy`: Kafka producer for sending notifications
  - `NotificationSenderManager`: Implementation of notification management

## Configuration
- Kafka bootstrap servers: `localhost:9092`
- Consumer group: `yqo-notification-group`
- Notification topic: `yqo-notifications`

## Dependencies
- Spring Boot
- Spring Kafka
- Lombok
- Jackson JSON

## Setup
1. Ensure Kafka is running on `localhost:9092`
2. Configure Kafka connection in `application.properties`
3. Add module to main project's `pom.xml`

## Usage
- Send notifications via `ForManagingNotificationSender`
- Consume notifications via `ForNotificationConsumer`
