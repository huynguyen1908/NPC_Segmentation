-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: npc_segmentation
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `prompt_id` int DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `response` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (1,1,'2025-11-28 11:03:34.662176','2025-11-28 11:03:34.662176','Tôi không phải là giao diện theo nghĩa truyền thống, và cũng không phải là một API theo nghĩa đen của từ đó.\n\n*   **Tôi là một mô hình ngôn ngữ AI, một chương trình máy tính.** Tôi là \"bộ não\" xử lý thông tin, phân tích câu hỏi của bạn và tạo ra câu trả lời.\n*   Để các ứng dụng khác (như trang web bạn đang dùng, ứng dụng di động, hay các phần mềm khác) có thể tương tác với tôi, họ thường gọi đến tôi thông qua một **API (Application Programming Interface)**. API chính là \"cầu nối\" hoặc \"cánh cổng\" để các phần mềm khác gửi yêu cầu đến tôi và nhận lại kết quả.\n*   Còn cái bạn đang nhìn thấy và tương tác (khung chat, nút gửi...) chính là **giao diện người dùng (UI - User Interface)** của ứng dụng hoặc nền tảng đó. Giao diện này dùng API để gửi yêu cầu của bạn đến tôi và hiển thị câu trả lời của tôi cho bạn.\n\nTóm lại:\n*   Bạn tương tác với **giao diện** (UI) của một ứng dụng.\n*   Ứng dụng đó dùng **API** để \"nói chuyện\" với tôi.\n*   Và tôi là **mô hình AI** nằm ở phía sau, xử lý thông tin và tạo ra phản hồi.'),(2,102,'2025-11-28 14:02:03.426541','2025-11-28 14:02:03.426541','Dựa trên hình ảnh, đây là mô tả chi tiết về đôi giày:\n\n**Tên sản phẩm:** Nike KD15 EP\n\n**Mô tả tổng quan:**\nĐây là mẫu giày bóng rổ Nike KD15 EP, nổi bật với phối màu độc đáo, tươi sáng và bắt mắt, kết hợp hài hòa giữa các tông màu pastel và rực rỡ. Đôi giày mang phong cách nghệ thuật, hiện đại, phù hợp cho cả việc thi đấu bóng rổ và sử dụng hàng ngày như một món đồ thời trang cá tính.\n\n**Chi tiết thiết kế và màu sắc:**\n\n1.  **Phối màu chủ đạo:**\n    *   **Thân giày (upper):** Phần lớn thân giày được làm từ chất liệu vải lưới (mesh) có màu **tím lavender (tím nhạt)** hoặc **tím mộng mơ**, với các họa tiết chìm dạng sóng hoặc vân độc đáo, tạo chiều sâu và sự mềm mại.\n    *   **Lớp phủ (overlay) và khung giữa thân giày:** Các chi tiết này có màu **xanh mint (xanh lá cây nhạt)** tươi mát, được thiết kế với các đường nét uốn lượn, mềm mại như những gợn sóng hoặc vân đá, ôm lấy thân giày, mang lại vẻ ngoài năng động và nghệ thuật.\n    *   **Logo Swoosh:** Dấu Swoosh đặc trưng của Nike được đặt ở má ngoài, có màu **tím đậm hơn** hoặc **tím violet**, tạo điểm nhấn mạnh mẽ trên nền xanh mint.\n    *   **Cổ giày và một số chi tiết nhỏ:** Mang màu **xanh ngọc (teal/turquoise)**, tạo sự tương phản nhẹ nhàng và tăng thêm sự đa dạng cho bảng màu.\n    *   **Đế giữa (midsole):** Phần lớn có màu trắng, tạo sự cân bằng cho tổng thể màu sắc.\n    *   **Đế ngoài (outsole):** Có màu xanh mint tương đồng với các lớp phủ, với các đường vân nổi được thiết kế để tối ưu hóa độ bám sân.\n\n2.  **Chất liệu:**\n    *   **Thân trên (Upper):** Được làm từ vải lưới (mesh) nhẹ và thoáng khí, giúp đôi chân luôn thoải mái và mát mẻ trong quá trình vận động.\n    *   **Lớp phủ:** Các lớp phủ tổng hợp (synthetic overlays) không chỉ tăng tính thẩm mỹ mà còn cung cấp sự hỗ trợ và ổn định cần thiết cho bàn chân khi di chuyển nhanh.\n\n3.  **Chi tiết đặc biệt:**\n    *   **Phần gót:** Trên giày bên trái có in số **\"07\"** màu trắng nổi bật, có thể là số áo của cầu thủ Kevin Durant hoặc một chi tiết mang ý nghĩa đặc biệt liên quan đến phiên bản này (thường thấy trong các phiên bản đặc biệt như \"Aunt Pearl\" hoặc các phiên bản lấy cảm hứng từ thiên nhiên).\n    *   **Dây giày:** Dây giày có màu tím nhạt, tiệp với màu thân giày.\n    *   **Thiết kế cổ thấp (Low-cut):** Giúp tăng cường sự linh hoạt và tự do cho mắt cá chân, phù hợp với phong cách chơi nhanh nhẹn.\n\n**Công nghệ (Đặc trưng của dòng KD):**\nDòng KD15 được biết đến với công nghệ đệm tiên tiến (thường là sự kết hợp của Zoom Air và/hoặc Cushlon) mang lại khả năng hấp thụ lực tốt, hoàn trả năng lượng hiệu quả và cảm giác êm ái, giúp người mang có thể bứt tốc và thay đổi hướng linh hoạt.\n\n**Thông tin khác (từ hình ảnh):**\n*   **Kích cỡ trên hộp:** US 10.5 (Nam) / UK 9 / EUR 44.5 / CM 28.5 (hoặc US 9 / UK 8 / EUR 42.5 / CM 27.5 cho nữ, tùy theo cách đọc bảng size).\n*   **Mã sản phẩm (Style Code):** DH0564 501 (có thể nhìn thấy trên nhãn hộp).\n\n**Tóm lại:** Đây là một đôi Nike KD15 EP với phối màu rực rỡ, độc đáo và đầy cá tính, kết hợp giữa hiệu năng cao trên sân bóng và vẻ ngoài thời trang ấn tượng.'),(3,252,'2025-11-28 14:38:01.640341','2025-11-28 14:38:01.640341','Có, tôi được thiết kế để làm điều đó!\n\nTôi có khả năng ghi nhớ và theo dõi các thông tin, chủ đề, và ý nghĩa của cuộc trò chuyện trong một phạm vi nhất định. Điều này cho phép tôi:\n\n*   **Hiểu các câu hỏi tiếp nối:** Nếu bạn nói về một chủ đề, sau đó đặt câu hỏi liên quan mà không lặp lại toàn bộ thông tin, tôi vẫn có thể hiểu bạn đang ám chỉ điều gì.\n    *   Ví dụ: \"Hôm qua tôi đi công viên ABC. Ở đó có nhiều cây xanh không?\" (Tôi sẽ hiểu \"ở đó\" là công viên ABC).\n*   **Duy trì tính liên tục của cuộc trò chuyện:** Giúp cuộc trò chuyện tự nhiên và mạch lạc hơn.\n*   **Trả lời các câu hỏi phụ thuộc ngữ cảnh:** Nếu bạn hỏi một câu chung chung, nhưng dựa vào các câu trước đó, tôi có thể đưa ra câu trả lời phù hợp hơn.\n\nTuy nhiên, cũng có một số giới hạn:\n\n*   **Độ dài cuộc trò chuyện:** Nếu cuộc trò chuyện quá dài hoặc quá phức tạp với nhiều chủ đề đan xen, khả năng ghi nhớ ngữ cảnh của tôi có thể bị giảm đi.\n*   **Sự thay đổi chủ đề đột ngột:** Nếu bạn chuyển từ chủ đề này sang chủ đề khác mà không có sự liên kết rõ ràng, tôi có thể cần bạn nhắc lại hoặc làm rõ chủ đề mới.\n\nNhìn chung, bạn cứ yên tâm trò chuyện và đặt câu hỏi. Tôi sẽ cố gắng hết sức để theo dõi và hiểu ngữ cảnh bạn đưa ra!');
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conversation`
--

DROP TABLE IF EXISTS `conversation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conversation` (
  `group_id` int DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conversation`
--

LOCK TABLES `conversation` WRITE;
/*!40000 ALTER TABLE `conversation` DISABLE KEYS */;
INSERT INTO `conversation` VALUES (NULL,1,1,'2025-11-28 11:03:14.176845','2025-11-28 11:03:14.176845',NULL);
/*!40000 ALTER TABLE `conversation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_seq`
--

DROP TABLE IF EXISTS `group_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_seq`
--

LOCK TABLES `group_seq` WRITE;
/*!40000 ALTER TABLE `group_seq` DISABLE KEYS */;
INSERT INTO `group_seq` VALUES (1);
/*!40000 ALTER TABLE `group_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image`
--

DROP TABLE IF EXISTS `image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `image` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
INSERT INTO `image` VALUES (1,1,'2025-11-28 11:28:27.675328','2025-11-28 11:28:27.675328',NULL,'D:\\project\\VDHDHTTT\\NPC_Segmentation_Web\\src\\main\\resources\\uploads\\1764329307649_Giay-bong-ro-nam-Nike-KD-15-Kevin-Durant-Nightmares-co-thap-replica-1-1-authentic-real-chinh-hang-gia-re-HCM-NK1997-2-2048x1536h.jpg'),(2,1,'2025-11-28 11:38:41.474666','2025-11-28 11:38:41.474666',NULL,'uploads/1764329921451_Giay-bong-ro-nam-Nike-KD-15-Kevin-Durant-Nightmares-co-thap-replica-1-1-authentic-real-chinh-hang-gia-re-HCM-NK1997-2-2048x1536h.jpg'),(3,1,'2025-11-28 13:48:14.658601','2025-11-28 13:48:14.658601',NULL,'uploads/1764337694619_Giay-bong-ro-nam-Nike-KD-15-Kevin-Durant-Nightmares-co-thap-replica-1-1-authentic-real-chinh-hang-gia-re-HCM-NK1997-2-2048x1536h.jpg'),(4,1,'2025-11-28 14:01:43.273038','2025-11-28 14:01:43.273038',NULL,'uploads/1764338503241_Giay-bong-ro-nam-Nike-KD-15-Kevin-Durant-Nightmares-co-thap-replica-1-1-authentic-real-chinh-hang-gia-re-HCM-NK1997-2-2048x1536h.jpg');
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prompt`
--

DROP TABLE IF EXISTS `prompt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prompt` (
  `conversation_id` int DEFAULT NULL,
  `id` int NOT NULL,
  `image_id` int DEFAULT NULL,
  `parent_id` int DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `answer_id` varbinary(255) DEFAULT NULL,
  `question` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prompt`
--

LOCK TABLES `prompt` WRITE;
/*!40000 ALTER TABLE `prompt` DISABLE KEYS */;
INSERT INTO `prompt` VALUES (1,1,NULL,0,'2025-11-28 11:03:24.916100','2025-11-28 11:03:24.916100',NULL,'Mày là api hay giao diện'),(NULL,2,1,0,'2025-11-28 11:28:27.831094','2025-11-28 11:28:27.867475',NULL,'Cho t thông tin mô tả về đôi giày trên'),(NULL,52,2,0,'2025-11-28 11:38:41.586783','2025-11-28 11:38:41.611040',NULL,'Cho t thông tin mô tả về đôi giày trên'),(NULL,53,3,0,'2025-11-28 13:48:14.717138','2025-11-28 13:48:14.726926',NULL,'Cho t thông tin mô tả về đôi giày trên'),(1,102,4,0,'2025-11-28 14:01:43.391619','2025-11-28 14:01:43.391619',NULL,'Cho t thông tin mô tả về đôi giày trên'),(1,252,NULL,0,'2025-11-28 14:37:52.427859','2025-11-28 14:37:52.427859',NULL,'mày có thể follow context được không');
/*!40000 ALTER TABLE `prompt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prompt_seq`
--

DROP TABLE IF EXISTS `prompt_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prompt_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prompt_seq`
--

LOCK TABLES `prompt_seq` WRITE;
/*!40000 ALTER TABLE `prompt_seq` DISABLE KEYS */;
INSERT INTO `prompt_seq` VALUES (351);
/*!40000 ALTER TABLE `prompt_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2025-11-28 11:02:56.494429','2025-11-28 11:02:56.494429','huynguyenvukhanh@gmai.com','$2a$10$Ztw1o18SSPYBb/qtsqfu0uv6UmhKSe0ZLPiJaDuFpPW7UZ9KOTAR2',NULL,'dev');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-29  0:15:28
