-- INSERT INTO messages(MTYPE, message_type, payload_type, options, payload)
-- VALUES ('TEXT', 'WELCOME', 'DSL', null, 'Hello Dear! I am glad you decided to ask me for help.\n' ||
--                           'I will do my best to recommend you the product you want.\n' ||
--                           'What are you looking for?\n' ||
--                           '**PC/Laptop,Large Appliances,Small Applicances,Electronics, More...**\n' ||
--                           'Or just write category or product you are searching :)'),
--        ('TEXT', 'WELCOME', 'DSL', null, 'Hi :) My name is Marcus. I am really happy to help you choosing one of our products.\n' ||
--                           'What are you looking for?\n' ||
--                           '**PC/Laptop,Large Appliances,Small Applicances,Electronics, More...**\n' ||
--                           'If this list is not satisfying for you pleas tell me what you desire :)'),
--        ('TEXT', 'WELCOME', 'DSL', null, 'Welcome! I am really happy to help you choosing one of our products.\n' ||
--                           'I have some propositions for you:\n' ||
--                           '**PC/Laptop,Large Appliances,Small Applicances,Electronics, More...**\n' ||
--                           'Or maybe just tell me! :)')
-- ON CONFLICT DO NOTHING;

-- INSERT INTO messages(MTYPE, message_type, payload_type, options, payload) VALUES ('TEXT', 'GOODBYE', 'DSL', null, 'Goodbye :) Happy to help.') ON CONFLICT DO NOTHING;

INSERT INTO messages (mtype, message_type, payload, payload_type, options) VALUES ('OPTIONS', 'WELCOME', 'xDD', 'OPTIONS', 'some,options') ON CONFLICT DO NOTHING;
