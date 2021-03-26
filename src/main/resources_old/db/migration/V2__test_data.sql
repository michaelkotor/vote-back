-- for testing

INSERT INTO participant_list
VALUES (7777, 'ParticipantListController List 1', 'Some description here', '["V1","V2","V3"]');

insert into POLL
values (77, 'Title77', 'Descr77', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,
        '[{"question":"Do you like me?", "options":["yes", "no", "stupid question"]}]',
        '{"id":"7777","title":"List1","participants":["V1","V2"]}', '9aRKbkGV1MURdCqoM5KBoAM9tFszv');

