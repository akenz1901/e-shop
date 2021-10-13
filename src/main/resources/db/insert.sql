set foreign_key_checks=0;

truncate table product;
truncate table feedback;

insert into product(`id`, `name`, `price`, `details`, `currency`)
value(110, 'luxury', 7500, 'Mhsbdicubeiuvbeurvieurevbierivbuerkjbeckusbicviebucvewiucvweciywecvwecewiycvwecew', 'SGD'),
(111, 'luxury sofa', 4000, 'Mhsbdicubeiuvbeurvieurevbierivbuerkjbeckusbicviebucvewiucvweciywecvwecewiycvwecew', 'NGN'),
(112, 'luxury bench', 6500, 'Mhsbdicubeiuvbeurvieurevbierivbuerkjbeckusbicviebucvewiucvweciywecvwecewiycvwecew', 'USD'),
(113, 'luxury table', 8500, 'Mhsbdicubeiuvbeurvieurevbierivbuerkjbeckusbicviebucvewiucvweciywecvwecewiycvwecew', 'USD');

set foreign_key_checks=1;