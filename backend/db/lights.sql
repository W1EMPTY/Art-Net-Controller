/*
 Navicat Premium Data Transfer

 Source Server         : ArtNet Controller
 Source Server Type    : SQLite
 Source Server Version : 3030001
 Source Schema         : main

 Target Server Type    : SQLite
 Target Server Version : 3030001
 File Encoding         : 65001

 Date: 28/08/2024 21:06:06
*/

PRAGMA foreign_keys = false;

-- ----------------------------
-- Table structure for lights
-- ----------------------------
DROP TABLE IF EXISTS "lights";
CREATE TABLE "lights" (
  "id" INTEGER PRIMARY KEY AUTOINCREMENT,
  "Brightness" INTEGER NOT NULL,
  "dmxAddress" INTEGER NOT NULL,
  "status" TEXT NOT NULL
);

-- ----------------------------
-- Auto increment value for lights
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 56 WHERE name = 'lights';

PRAGMA foreign_keys = true;
