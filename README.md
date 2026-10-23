# 小候鸟关爱平台

小候鸟关爱宣传展示与后台管理系统。

## 项目结构

- `frontend/`：静态前端页面及模拟数据。
- `xiaohouniao-platform/`：Spring Boot 3.2.8、Java 17、MyBatis Plus、MySQL 后端，包含静态页面和数据库初始化脚本。
- `continew-admin/`：随项目提供的 ContiNew Admin 管理后台源码，原始说明和 Apache-2.0 许可保留在该目录。

## 运行小候鸟后端

1. 安装 Java 17、Maven 和 MySQL。
2. 执行 `xiaohouniao-platform/src/main/resources/db/schema.sql` 创建数据库和表。
3. 在系统环境变量中设置 `DB_USERNAME`、`DB_PASSWORD`、`JWT_SECRET`。数据库默认地址为 `127.0.0.1:3306/xiaohouniao`。JWT 密钥应为随机生成且至少 32 字节的字符串。
4. 在 `xiaohouniao-platform/` 目录执行 `mvn spring-boot:run`。
5. 浏览器访问 `http://localhost:8080/`。

`.env.example` 仅作为环境变量清单，Spring Boot 不会自动加载此文件。管理后台使用独立配置，所需密钥也列在该清单中；按实际使用的模块配置。

源码包含演示数据初始化逻辑和演示管理员账号，正式部署前应调整初始化策略并更换默认管理员密码。

## 提交范围

保留应用源码、前端、数据库脚本和管理后台。构建产物、日志、上传文件、IDE 设置及本地 Git 历史未上传。配置文件中的密码与私钥已改为环境变量引用。
