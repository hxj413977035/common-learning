package com.info.streamApi.stream;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 * @Description:
 * @CreateTime 2018-08-16 上午 9:28
 **/
public class Streams {

    public static void main(String[] args) {
        final Collection<Task> tasks = Arrays.asList(
                new Task(Status.OPEN, 5),
                new Task(Status.OPEN, 13),
                new Task(Status.CLOSED, 8)
        );

        // 状态为OPEN的任务一共有多少分数
        /**
         * 第一，task集合被转换化为其相应的stream表示。
         * 然后，filter操作过滤掉状态为CLOSED的task。
         * 下一步，mapToInt操作通过Task::getPoints这种
         * 方式调用每个task实例的getPoints方法把Task的stream
         * 转化为Integer的stream。最后，用sum函数把所有的分数加起来，得到最终的结果。
         *
         * stream操作被分成了中间操作与最终操作这两种。
         * 中间操作返回一个新的stream对象。中间操作总是采用惰性求值方式，
         * 运行一个像filter这样的中间操作实际上没有进行任何过滤，
         * 相反它在遍历元素时会产生了一个新的stream对象，这个新的stream对象包含原始stream
         * 中符合给定谓词的所有元素
         *
         * 像forEach、sum这样的最终操作可能直接遍历stream，
         * 产生一个结果或副作用。当最终操作执行结束之后，
         * stream管道被认为已经被消耗了，没有可能再被使用了。在大多数情况下，
         * 最终操作都是采用及早求值方式，及早完成底层数据源的遍历。
         */
        final int totalPointsOfOpenTasks = tasks.stream().filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints).sum();
        System.out.println("Total points: " + totalPointsOfOpenTasks);

        /**
         * stream另一个有价值的地方是能够原生支持并行处理。让我们来看看这个算task分数和的例子
         *
         * 这个例子和第一个例子很相似，但这个例子的不同之处在于这个程序是并行运行的，其次使用reduce方法来算最终的结果。
         */
        final int totalPoints = tasks.stream().parallel().
                map(task -> task.getPoints()).reduce(0, Integer::sum);
        System.out.println("Total points (all tasks): " + totalPoints);

        /**
         * 经常会有这个一个需求：我们需要按照某种准则来对集合中的元素进行分组。Stream也可以处理这样的需求
         */
        final Map<Status, List<Task>> map = tasks.stream().collect(Collectors.groupingBy(Task::getStatus));
        System.out.println(map);

        /**
         * 计算整个集合中每个task分数（或权重）的平均值
         */
        final Collection<String> result = tasks
                .stream()                                      // Stream< String >
                .mapToInt(Task::getPoints)                     // Int Stream
                .asLongStream()                                // Long Stream
                .mapToDouble(points -> points / totalPoints)   // Double Stream
                .boxed()                                       // Stream< Double >
                .mapToLong(weight -> (long) (weight * 100))    // Long Stream
                .mapToObj(percentage -> percentage + "%")      // Stream< String>
                .collect(Collectors.toList());                 // List< String >
        System.out.println(result);

        /**
         * Stream API不仅仅处理Java集合框架。像从文本文件中逐行读取数据这样典型的I/O操作也很适合用Stream API来处理
         *
         * 对一个stream对象调用onClose方法会返回一个在原有功能基础上新增了关闭功能的stream对象，
         * 当对stream对象调用close()方法时，与关闭相关的处理器就会执行
         *
         * Stream API、Lambda表达式与方法引用在接口默认方法与静态方法的配合下是Java 8对现代软件开发范式的回应
         */
        String filename = null;
        final Path path = new File(filename).toPath();
        try (Stream<String> lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.onClose(() -> System.out.println("Done!")).forEach(System.out::println);
        } catch (Exception e) {

        }
    }

    private enum Status {

        OPEN, CLOSED

    }

    ;

    private static final class Task {

        private final Status status;

        private final Integer points;

        Task(final Status status, final Integer points) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format("[%s, %d]", status, points);
        }
    }
}
