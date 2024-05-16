package net.haxjakt.springtest.service;

import lombok.AllArgsConstructor;
import net.haxjakt.springtest.repository.DemoRepository;
import net.haxjakt.springtest.repository.DemoType;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DemoService {
    private final DemoRepository demoRepository;
    public String fetchAndIncrementCounter() {
        var demoList = demoRepository.findAll();

        if (demoList.isEmpty()) {
            var counter = createNewCounter();
            return counter.getCount().toString();
        }

        var counter = demoList.get(0);
        counter.setCount(counter.getCount() + 1);
        counter = demoRepository.save(counter);

        return counter.getCount().toString();
    }

    private DemoType createNewCounter() {
        var demo = new DemoType(null, 1);
        return demoRepository.save(demo);
    }
}
