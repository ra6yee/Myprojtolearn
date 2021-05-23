package синтаксис;

/*
тип boolean. Переменные этого типа могут принимать всего два значения – true (истина/правда) и false (ложь).
Значение переменой типа boolean по умолчанию false («ложь»).


— А что мне делать, если я хочу записать, выражение 0<a<b?

— Ну, выражений, которые включают три оператора, в Java нет, поэтому тут нужно воспользоваться такой конструкцией: (0<a) И (a<b)

— Так и писать И?

— Подожди, сейчас все объясню. В Java есть три логических оператора: AND (и), OR (или) и NOT (не).
 С помощью них можно строить условия различной сложности. Эти операторы можно применять только к выражению,
  имеющему тип boolean. Т.е. (a+1) AND (3) написать нельзя, а (a>1)AND (a<3) – можно.

— Оператор NOT – унарный – его действие распространяется только на выражение справа от него.
 Он больше похож на знак «минус» перед отрицательным числом, чем на знак умножить

— С переменными типа boolean (логический тип) можно выполнять различные операции.

— А какие?

— Вот сейчас мы их и рассмотрим:

Логический oператор	Обозначение в Java	Выражение	Результат
AND (и)	&&	true && true	true
true && false	false
false && true	false
false && false	false
OR (или)	||	true || true	true
true || false	true
false || true	true
false || false	false
NOT(не)	!	! true	false
! false	true
Распространённые комбинации и выражения	m && !m	false
m || !m	true
! (a && b)	!a || !b
! (a || b)	!a && !b
 */

public class тип_boolean {


}
