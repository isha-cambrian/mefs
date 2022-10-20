CREATE SCHEMA "capVIG4";

CREATE TYPE "capVIG4"."user_types" AS ENUM (
  'employee',
  'manager'
);

CREATE TYPE "capVIG4"."email_clients" AS ENUM (
  'mail_chimp'
);

CREATE TYPE "capVIG4"."communication_types" AS ENUM (
  'action_item',
  'milestone'
);

CREATE TYPE "capVIG4"."action_item_statuses" AS ENUM (
  'created',
  'communicated',
  'overude',
  'done',
  'failed'
);

CREATE TYPE "capVIG4"."milestone_statuses" AS ENUM (
  'created',
  'communicated',
  'overude',
  'done',
  'failed'
);

CREATE TABLE "capVIG4"."organizations" (
  "id" int PRIMARY KEY,
  "name" varchar,
  "created_at" datetime
);

CREATE TABLE "capVIG4"."users" (
  "id" int PRIMARY KEY,
  "name" varchar,
  "email" varchar,
  "organization_id" int,
  "user_type" capVIG4.user_types,
  "salt" varchar,
  "username" varchar,
  "password" varchar,
  "created_at" datetime
);

CREATE TABLE "capVIG4"."interactions" (
  "id" int PRIMARY KEY,
  "manager_id" int,
  "subordinate_id" int,
  "schedule_date" datetime,
  "created_at" datetime
);

CREATE TABLE "capVIG4"."sessions" (
  "id" int,
  "session_token" varchar,
  "user_id" id,
  "created_at" datetime,
  "exipre_at" datetime
);

CREATE TABLE "capVIG4"."communications" (
  "id" int[pk],
  "user_id" int,
  "communication_type" capVIG4.communication_types,
  "body" text,
  "email_client" capVIG4.email_clients,
  "created_at" datetime
);

CREATE TABLE "capVIG4"."feedbacks" (
  "id" int,
  "interaction_id" int,
  "body" text,
  "created_at" datetime,
  "due_date" date
);

CREATE TABLE "capVIG4"."action_items" (
  "id" int,
  "feedback_id" int,
  "body" text,
  "status" capVIG4.action_item_statuses,
  "created_at" datetime,
  "updated_at" datetime,
  "due_date" date
);

CREATE TABLE "capVIG4"."milestones" (
  "id" int,
  "feedback_id" int,
  "body" text,
  "status" capVIG4.milestone_statuses,
  "created_at" datetime,
  "updated_at" datetime,
  "due_date" date
);

CREATE INDEX "schedule_date" ON "capVIG4"."interactions" ("schedule_date");

CREATE INDEX "user_session" ON "capVIG4"."sessions" ("session_token", "user_id");

CREATE INDEX "interaction_feedback" ON "capVIG4"."feedbacks" ("interaction_id");

CREATE INDEX "feedback_action_items" ON "capVIG4"."action_items" ("feedback_id", "status", "due_date");

CREATE INDEX "feedback_action_items" ON "capVIG4"."milestones" ("feedback_id", "status", "due_date");

ALTER TABLE "capVIG4"."users" ADD FOREIGN KEY ("organization_id") REFERENCES "capVIG4"."organizations" ("id");

ALTER TABLE "capVIG4"."users" ADD FOREIGN KEY ("id") REFERENCES "capVIG4"."interactions" ("manager_id");

ALTER TABLE "capVIG4"."users" ADD FOREIGN KEY ("id") REFERENCES "capVIG4"."interactions" ("subordinate_id");

ALTER TABLE "capVIG4"."users" ADD FOREIGN KEY ("id") REFERENCES "capVIG4"."sessions" ("user_id");

ALTER TABLE "capVIG4"."communications" ADD FOREIGN KEY ("user_id") REFERENCES "capVIG4"."users" ("id");

ALTER TABLE "capVIG4"."interactions" ADD FOREIGN KEY ("id") REFERENCES "capVIG4"."feedbacks" ("interaction_id");

ALTER TABLE "capVIG4"."feedbacks" ADD FOREIGN KEY ("id") REFERENCES "capVIG4"."action_items" ("feedback_id");

ALTER TABLE "capVIG4"."feedbacks" ADD FOREIGN KEY ("id") REFERENCES "capVIG4"."milestones" ("feedback_id");
